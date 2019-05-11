package com.wxthxy.market.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.market.entity.Goods;
import com.wxthxy.market.entity.Refuse;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.GoodsService;
import com.wxthxy.market.service.RefuseService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;
/**
 * 库存Controller
 * @author Dell
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private  GoodsService goodsservice;
	@Resource
	private RefuseService refuseservice;
	@RequestMapping(value = "/goodslist")
	@ResponseBody
	public Object getgoodslist(){
		HashMap<String,Object> result =new HashMap<String,Object>(); 

		List<Goods> list= goodsservice.goodslist();
		if(list!=null){
			result.put("goodslist",list);
		}
		return JSONArray.toJSONString(result);
	}
	
	@RequestMapping("/goodslist.html")
	public String billlist(@RequestParam(value = "querygcode",required = false) String gcode,
			@RequestParam(value = "querygname",required = false) String gname,
			@RequestParam(value = "pageIndex",required = false) String pageIndex,
			Model m ,HttpSession session){
		if(gcode ==null){
			gcode ="";
		}
		if(gname==null){
			gname ="";
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
		int totalcount=goodsservice.getcount(gcode, gname);
		pages.setTotalCount(totalcount);//总记录数
		int totalPageCount = pages.getTotalPageCount(); //总页数
		//控制首页和尾页
		if(currentpage < 1){   //如果当前页码小于1 就等于1
			currentpage = 1;
		}else if(currentpage > totalPageCount){ //如果当前页码大于总页数  就等于总页数
			currentpage = totalPageCount;
		}
		List<Goods> goodslist= goodsservice.getgoodsList(gcode, gname,((currentpage-1)*pageSize), pageSize);
		m.addAttribute("goods",goodslist);
		m.addAttribute("querygcode",gcode );//用于数据回显    
		m.addAttribute("querygname",gname); //用于数据回显
		m.addAttribute("totalPageCount", totalPageCount); //总页数
		m.addAttribute("totalCount",totalcount); //查找到的总记录数
		m.addAttribute("currentPageNo",currentpage);//当前页码
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "goodslist";
		}
		return "user/goodslist";
		
	}
	@RequestMapping("/goodsadd.html")
	public String goodsadd(@ModelAttribute Goods g) {
		return "goodsadd";
		
	}
	@RequestMapping("/savegoods.html")
	public String savegoods(Goods goods
			,HttpSession session,String gname,HttpServletRequest request){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		System.out.println("loginerid==========="+loginerid);
		goods.setCreatedBy(loginerid);
		goods.setSname(gname);
		goods.setCreationDate(new Date());
		if(goodsservice.findgoodsbygname(goods.getGname())!=null) {
			request.setAttribute("error", "库存里已存在该商品");
			return "goodsadd";
		}
		else {
			goodsservice.savegoods(goods);
				return "redirect:/goods/goodslist.html";
		}
		
	}
	@RequestMapping("/view/{id}")
	public String goodsView(@PathVariable String id,Model m) {
		Goods g=new Goods();
		g=goodsservice.findgoodsbyid(id);
		m.addAttribute("goods", g);
		return "goodsview";
	}
	@RequestMapping("/updategoods/{id}")
	public String updategoods(@PathVariable String id ,@ModelAttribute Goods goods,Model m) {
		goods = goodsservice.findgoodsbyid(id);
		m.addAttribute("goods",goods);
		return "goodsmodify";
	}
	@RequestMapping("/saveupdategoods")
	public String saveupdategoods(Goods goods
			,HttpSession session) {
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		goods.setModifyBy(loginerid);
		//创建时间
		goods.setModifyDate( new  Date());
		if(goodsservice.updategoodsbyid(goods)==1){
			return "redirect:/goods/goodslist.html";
		}
		return "goodsadd";
	}
	@RequestMapping("/deletegoodsbyid/{id}")
	@ResponseBody
	public String  deletegoods(@PathVariable String id,HttpSession session) {
		HashMap<String,Object> m = new HashMap<String,Object>();
		if(id==null||id==""){
			m.put("delResult", "notexist");
		}else{
			Goods goods=goodsservice.findgoodsbyid(id);
			int count=  goodsservice.deletegoodsbyid(id);
			Refuse refuse=new Refuse();
			refuse.setCreateBy(((User)session.getAttribute(Constants.SESSION)).getId());
			refuse.setCreationDate(new Date());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			refuse.setRefCode("TH"+sdf.format(new Date()));
			refuse.setRefName(goods.getGname());
			refuse.setRefnumber(goods.getGnumber());
			refuse.setRefReasion("清空"+goods.getGname()+"的库存");
			refuse.setRefunit(goods.getGunit());
			refuseservice.saveRefuse(refuse);
			if(count>0){
				m.put("delResult", "true");
			}else{
				m.put("delResult", "false");
			}
		}
		return JSONArray.toJSONString(m);
	}
	
	
}