package com.wxthxy.market.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;
import com.wxthxy.market.entity.Sale;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.GoodsService;
import com.wxthxy.market.service.SaleService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;
/**
 * 订单Controller
 * @author Dell
 *
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
	@Resource
	private  SaleService saleservice;
	@Resource
	private GoodsService goodsservice;
	@RequestMapping("/salelist.html")
	public String salelist(@RequestParam(value = "queryscode",required = false) String scode,
			@RequestParam(value = "querysname",required = false) String sname,
			@RequestParam(value = "pageIndex",required = false) String pageIndex,
			Model m,HttpSession session){
		if(scode==null){
			scode ="";
		}
		if(sname == null){
			sname="";
		}
		int currentpage = 1; //当前页   //默认从第一页开始
		int pageSize = Constants.pageSize; //页面容量
		if(pageIndex!=null){
			try {
				currentpage = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				//否则就跳转到错误页面
				return  "redirect:/syserror.html";
			}
		}
		PageSupport pages=new PageSupport();
		pages.setCurrentPageNo(currentpage);//当前页
		pages.setPageSize(pageSize); //页面容量
		int totalcount=saleservice.getcount(scode, sname);
		pages.setTotalCount(totalcount);//总记录数
		int totalPageCount = pages.getTotalPageCount(); //总页数
		//控制首页和尾页
		if(currentpage < 1){   //如果当前页码小于1 就等于1
			currentpage = 1;
		}else if(currentpage > totalPageCount){ //如果当前页码大于总页数  就等于总页数
			currentpage = totalPageCount;
		}
		List<Sale> salelist= saleservice.getsaleList(scode, sname, ((currentpage-1)*pageSize), pageSize);
		m.addAttribute("sale",salelist);
		m.addAttribute("queryscode",scode );//用于数据回显    
		m.addAttribute("querysname",sname); //用于数据回显   
		m.addAttribute("totalPageCount", totalPageCount); //总页数
		m.addAttribute("totalCount",totalcount); //查找到的总记录数
		m.addAttribute("currentPageNo",currentpage);//当前页码
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "salelist";
		}
		return "user/salelist";
	}
	@RequestMapping("/saleadd.html")
	public String saleadd(@ModelAttribute Sale sale){
		return "saleadd";
	}
	
	@RequestMapping("/savesale.html")
	public String savesale(Sale sale,HttpSession session,String snumber
			,String sname,Model m){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		sale.setCreatedBy(loginerid);
		;
		sale.setPprice(goodsservice.findgoodsbygname(sname).getPprice());
		//创建时间
		sale.setCreationDate( new  Date());
		if(saleservice.savesale(sale)==1){
			Goods g=goodsservice.findgoodsbygname(sname);
			int gnumber=g.getGnumber();
			int _snumber=Integer.parseInt(snumber);
			if(gnumber-_snumber>=0) {
				System.out.println("==========================添加到销售单的个数="+_snumber);
				goodsservice.updategoodsbynumber(_snumber, sname);
				return "redirect:/sale/salelist.html";
			}
				String error="仓库的"+sname+"数量不足";
			/*int _gnumber=g.getGnumber();
			System.out.println("=========================snumber="+snumber);
			System.out.println("=========================sname="+sname);
			System.out.println("==========================数量="+_gnumber);
			_gnumber=_gnumber-Integer.parseInt(snumber);*/
			m.addAttribute("error", error);
			return "saleadd";
		}
		return "saleadd";
	}
	@RequestMapping("/view/{id}")
	public String viewsale(@PathVariable String id,Model m) {
		Sale s=new Sale();
		s=saleservice.findsaleByid(id);
		m.addAttribute("sale", s);
		return "saleview";
	}
	@RequestMapping("/deletesalebyid/{id}")
	@ResponseBody
	public Object deletesale(@PathVariable String id){
		HashMap<String,Object> m = new HashMap<String,Object>();
		if(id==null||id==""){
			m.put("delResult", "notexist");
		}else{
			int count=  saleservice.deletesalebyid(id);
			if(count>0){
				m.put("delResult", "true");
			}else{
				m.put("delResult", "false");
			}
		}
		return JSONArray.toJSONString(m);
	}
	@RequestMapping("/updatesale/{id}")
	public String updatesale(@PathVariable String id ,@ModelAttribute Sale sale,Model m) {
		sale = saleservice.findsaleByid(id);
		m.addAttribute("sale",sale);
		return "salemodify";
	}
	@RequestMapping("/saveupdatesale.html")
	public String saveupdatesale(Sale sale
			,HttpSession session) {
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		sale.setModifyBy(loginerid);
		//创建时间
		sale.setModifyDate( new  Date());
		if(saleservice.updatesalebyid(sale)==1){
			return "redirect:/sale/salelist.html";
		}
		return "saleadd";
	}
	
	
	
	
}