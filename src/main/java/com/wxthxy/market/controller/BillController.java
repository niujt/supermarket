package com.wxthxy.market.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;
import com.wxthxy.market.entity.Provider;
import com.wxthxy.market.entity.Refuse;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.BillService;
import com.wxthxy.market.service.GoodsService;
import com.wxthxy.market.service.ProviderService;
import com.wxthxy.market.service.RefuseService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;
/**
 * 订单Controller
 * @author Dell
 *
 */
@Controller
@RequestMapping("/bill")
public class BillController {
	@Resource
	private  GoodsService goodsservice;
	@Resource
	private  BillService billservice;
	@Resource
	private ProviderService providerservice;
	@Resource
	private RefuseService refuseservice;
	/**
	 * 进入订单列表
	 * @param productName
	 * @param providerid
	 * @param isPayment
	 * @param pageIndex
	 * @param m
	 * @return
	 */
	@RequestMapping("/billlist.html")
	public String billlist(@RequestParam(value = "queryProductName",required = false) String productName,
			@RequestParam(value = "queryProviderId",required = false) String providerid,
			@RequestParam(value = "queryIsPayment",required = false) String isPayment,
			@RequestParam(value = "pageIndex",required = false) String pageIndex,
			Model m ,HttpSession session){
		int _providerid =0;  //供应商id
		int _isPayment = 0;    //是否付款
		if(productName ==null){
			productName ="";
		}
		if(providerid != null && !providerid.equals("")){
			_providerid = Integer.parseInt(providerid);
		}
		if (isPayment!=null && !isPayment.equals("")){
			_isPayment = Integer.parseInt(isPayment);
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
		int totalcount=billservice.getcount(productName,_providerid, _isPayment);
		pages.setTotalCount(totalcount);//总记录数
		int totalPageCount = pages.getTotalPageCount(); //总页数
		//控制首页和尾页
		if(currentpage < 1){   //如果当前页码小于1 就等于1
			currentpage = 1;
		}else if(currentpage > totalPageCount){ //如果当前页码大于总页数  就等于总页数
			currentpage = totalPageCount;
		}
		List<Bill> billlist= billservice.billlist(productName, _providerid, _isPayment, ((currentpage-1)*pageSize), pageSize);
		m.addAttribute("bill",billlist);
		m.addAttribute("queryProductName",productName );//用于数据回显    用户名
		m.addAttribute("queryProviderId",_providerid); //用于数据回显    角色id
		m.addAttribute("queryIsPayment", _isPayment);// 是否付款
		m.addAttribute("totalPageCount", totalPageCount); //总页数
		m.addAttribute("totalCount",totalcount); //查找到的总记录数
		m.addAttribute("currentPageNo",currentpage);//当前页码	
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "billlist";
		}
		return "user/billlist";
	}
	/**
	 * 进入添加订单列表
	 * @param bill
	 * @return
	 */
	@RequestMapping("/billadd.html")
	public String billadd(@ModelAttribute Bill bill){
		return "billadd";
	}
	/**
	 * 把要添加的订单保存到数据库
	 * @param bill
	 * @param session
	 * @return
	 */
	@RequestMapping("/savebill.html")
	public String savebill(Bill bill,HttpSession session
			){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		bill.setCreatedBy(loginerid);
		//创建时间
		bill.setCreationDate( new  Date());
		if(billservice.savebill(bill)==1){
			if(bill.getIsin()==2) {
				Goods g=new Goods();
				g.setCreatedBy(loginerid);
				g.setCreationDate( new  Date());
				BigDecimal b1=bill.getTotalPrice();
				BigDecimal b2=bill.getProductCount();
				System.out.println("bill单价============="+b1);
				System.out.println("bill总价============="+b2);
				g.setGnumber(b1.intValue()/b2.intValue());
				g.setPprice(bill.getProductCount());
				g.setSname(bill.getProductName());
				g.setGname(bill.getProductName());
				g.setGunit(bill.getProductUnit());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				g.setGcode("KC"+sdf.format(new Date()));
				goodsservice.savegoods(g);
			}
			
			return "redirect:/bill/billlist.html";
		}
		return "billadd";
	}
	/**
	 * 根据id查询订单信息
	 * @param id
	 * @param m
	 * @return
	 */
	@RequestMapping(value="view/{id}",method = RequestMethod.GET)
	public String getbillbyid(@PathVariable String id ,Model m){

		Bill bill=  billservice.getBillbyid(id);
		m.addAttribute("bill", bill);

		return "billview";
	}

	/**
	 * 进入修改页面
	 * @param id
	 * @param bill
	 * @param m
	 * @return
	 */
	@RequestMapping(value="updatebill/{id}",method = RequestMethod.GET)
	public String updatebill(@PathVariable String id,@ModelAttribute Bill bill,Model m){
		//根据id查找到订单信息
		Bill b= billservice.getBillbyid(id);
		m.addAttribute("bill", b);
		//供应商列表
		List<Provider> providerlist= providerservice.providerlist();
		m.addAttribute("providerList", providerlist);
		return "billmodify";
	}
	/**
	 * 点击保存修改的订单信息
	 * @param bill
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/saveupdatebill.html",method=RequestMethod.POST)
	public String saveupdatebill(Bill bill,HttpSession session){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		bill.setModifyBy(loginerid);
		//创建时间
		bill.setModifyDate( new  Date());
		if(billservice.updatebillbyid(bill)==1){
			return "redirect:/bill/billlist.html";
		}
		return "billadd";
	}
	/**
	 * 根据id删除订单信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletebillbyid/{id}")
	@ResponseBody
	public String deletebillbyid(@PathVariable String id,HttpSession session){
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(id==null || id ==""){
			result.put("delResult","notexist");
		}
		try {
			Bill bill=billservice.getBillbyid(id);
			int  count= billservice.deletebillbyid(id);
			System.out.println("count====================="+count);
			System.out.println("bill====================="+bill);
			System.out.println("食肉入库=========================="+bill.getIsin());
			if(bill.getIsin()==1) {
				Refuse refuse=new Refuse();
				refuse.setCreateBy(((User)session.getAttribute(Constants.SESSION)).getId());
				refuse.setCreationDate(new Date());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				refuse.setRefCode("TH"+sdf.format(new Date()));
				refuse.setRefName(bill.getProductName());
				refuse.setRefnumber((bill.getTotalPrice().intValue())/(bill.getProductCount().intValue()));
				refuse.setRefReasion("取消"+bill.getProductName()+"的订单");
				refuse.setRefunit(bill.getProductUnit());
				refuseservice.saveRefuse(refuse);
			}
			if(count>0){  //如果删除成功
				System.out.println("删除成功");
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