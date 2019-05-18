package com.wxthxy.supermarket.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.RefuseService;
import com.wxthxy.supermarket.util.Constants;

@Controller
@RequestMapping("/refuse")
public class RefuseController {
	//退货单Controller
	@Resource
	private  RefuseService refuseservice;
	@Resource
	private  GoodsService goodsservice;
	//进入退货单列表
	@RequestMapping("/refuselist.html")
	public String refuselist(){
		return "list/refuselist";
	}
	@RequestMapping(value = "/json/refuselist",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject showproviderlist(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","");
		json.put("count",refuseservice.getCount());
		List<Refuse> refuses=refuseservice.getRefuseList((page-1)*limit,limit);
		json.put("data",refuses);
		return json;
	}
	//进入添加订单列表
	@RequestMapping("/refuseadd.html")
	public String refuseadd(){

		return "add/refuseadd";
	}
	//进入修改页面
	@RequestMapping(value="updaterefuse.html/{id}",method = RequestMethod.GET)
	public String updaterefuse(@PathVariable String id, HttpServletRequest request){
		//根据id查找到订单信息
		Refuse r= refuseservice.getRefusebyid(id);
		request.setAttribute("refuse",r);
		return "info/refusemodify";
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