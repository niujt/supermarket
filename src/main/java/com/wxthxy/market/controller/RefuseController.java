package com.wxthxy.market.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.market.entity.Refuse;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.GoodsService;
import com.wxthxy.market.service.RefuseService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;

@Controller
@RequestMapping("/refuse")
public class RefuseController {
	//退货单Controller
	@Resource
	private  RefuseService refuseservice;
	@Resource
	private  GoodsService goodsservice;
	//角色信息
		@RequestMapping(value = "/refuselist",method = RequestMethod.GET)
		@ResponseBody
		public String refuselist(){
			HashMap<String,Object> result =new HashMap<String,Object>(); 
			List<Refuse> refuselist= refuseservice.Refuselist();
			if(refuselist!=null){
				result.put("refuselist",refuselist);
			}
			return JSONArray.toJSONString(result);
		}
	//进入退货单列表
	@RequestMapping("/refuselist.html")
	public String refuselist(@RequestParam(value = "queryRefName",required = false) String refuseName,
			@RequestParam(value = "queryRefCode",required = false) String refuseCode,
			@RequestParam(value = "pageIndex",required = false) String pageIndex,
			Model m,HttpSession session){
		if(refuseName ==null){
			refuseName ="";
		}
		if(refuseCode ==null){
			refuseCode ="";
		}
		int currentpage = 1; //当前页   //默认从第一页开始
		int pageSize = Constants.pageSize; //页面容量
		if(pageIndex!=null){
			try {
				currentpage = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				//否则就跳转到错误页面
				return  "redirect:/user/syserror.html";
			}
		}
		PageSupport pages=new PageSupport();
		pages.setCurrentPageNo(currentpage);//当前页
		pages.setPageSize(pageSize); //页面容量
		int totalcount=refuseservice.GetCount(refuseCode,refuseName);
		pages.setTotalCount(totalcount);//总记录数
		int totalPageCount = pages.getTotalPageCount(); //总页数
		//控制首页和尾页
		if(currentpage < 1){   //如果当前页码小于1 就等于1
			currentpage = 1;
		}else if(currentpage > totalPageCount){ //如果当前页码大于总页数  就等于总页数
			currentpage = totalPageCount;
		}
		List<Refuse> refuselist= refuseservice.GetRefuseList(refuseName, refuseCode,((currentpage-1)*pageSize), pageSize);
		m.addAttribute("refuseList",refuselist);
		m.addAttribute("queryRefName",refuseName );//用于数据回显    退货名称
		m.addAttribute("queryRefCode",refuseCode);//用于数据回显 退货编码
		m.addAttribute("totalPageCount", totalPageCount); //总页数
		m.addAttribute("totalCount",totalcount); //查找到的总记录数
		m.addAttribute("currentPageNo",currentpage);//当前页码
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "refuselist";
		}
		return "user/refuselist";
	}
	
	//进入添加订单列表
	@RequestMapping("/refuseadd.html")
	public String refuseadd(@ModelAttribute Refuse refuse){
		return "refuseadd";
	}
	//把要添加的订单保存到数据库
	@RequestMapping("/saverefuse.html")
	public String saverefuse(Refuse refuse,HttpSession session){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();
		//System.out.println("id==============================="+loginerid);
		refuse.setCreateBy(loginerid);
		//创建时间
		refuse.setCreationDate( new  Date());
		if(refuseservice.saveRefuse(refuse)==1){
			System.out.println("名称==================================sname===="+refuse.getRefName());
			goodsservice.updategoodsbynumber(refuse.getRefnumber(), refuse.getRefName());
			return "redirect:/refuse/refuselist.html";
		}
		return "refuseadd";
	}
	
	//根据id查询订单信息
	@RequestMapping(value="view/{id}",method = RequestMethod.GET)
	public String getrefusebyid(@PathVariable String id ,Model m){

		Refuse refuse=  refuseservice.getRefusebyid(id);
		m.addAttribute("refuse", refuse);

		return "refuseview";
	}

	//进入修改页面
	@RequestMapping(value="updaterefuse/{id}",method = RequestMethod.GET)
	public String updaterefuse(@PathVariable String id,@ModelAttribute Refuse refuse,Model m){
		//根据id查找到订单信息
		Refuse r= refuseservice.getRefusebyid(id);
		if(goodsservice.findgoodsbygname(r.getRefName()).getGnumber()>=r.getRefnumber()) {
			goodsservice.updategoodsbynumber(r.getRefnumber(), r.getRefName());
		}
		m.addAttribute("error","抱歉,"+r.getRefName()+"的库存不足");
		m.addAttribute("refuse",r);
		return "refusemodify";
	}
	//点击保存修改的订单信息
	@RequestMapping(value="saveupdaterefuse.html",method=RequestMethod.POST)
	public String saveupdaterefuse(Refuse refuse,HttpSession session){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		refuse.setModifyBy(loginerid);
		//创建时间
		refuse.setModifyDate( new  Date());
		if(refuseservice.updateRefusebyid(refuse)==1){
			return "redirect:/refuse/refuselist.html";
		}
		return "refuseadd";
	}
	//根据id删除订单信息
	@RequestMapping(value="/deleterefusebyid/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String deleterefusebyid(@PathVariable String id){
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(id==null || id ==""){
			result.put("delResult","notexist");
		}
		Refuse r=refuseservice.getRefusebyid(id);
		try {
			System.out.println("id==================================="+id);
			int  count= refuseservice.deleteRefusebyid(id);
			System.out.println(count+"++++++++++++++++++++++++++++++++++++++");
			if(count>0){  //如果删除成功
				System.out.println("r================rrrrrrr======"+r);
				goodsservice.updategoodsbynumber2(r.getRefnumber(), r.getRefName());
				result.put("delResult","true");
			}else{//否则
				result.put("delResult","false");
			}
			
		} catch (Exception e) {
			e.getStackTrace();
			result.put("delResult","false");
		}	
		return JSONArray.toJSONString(result);
	}
}