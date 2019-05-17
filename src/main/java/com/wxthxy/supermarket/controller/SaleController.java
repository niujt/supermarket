package com.wxthxy.supermarket.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Goods;
import com.wxthxy.supermarket.entity.Sale;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.SaleService;
import com.wxthxy.supermarket.util.Constants;
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
	public String showsalelist(){
		return "list/salelist";
	}
	@RequestMapping(value = "/json/salelist",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject showsalelist(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","");
		json.put("count",saleservice.getcount());
		List<Sale> sales=saleservice.getsaleList(page-1,limit);
		json.put("data",sales);
		return json;
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