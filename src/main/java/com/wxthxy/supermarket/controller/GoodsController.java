package com.wxthxy.supermarket.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Goods;
import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.RefuseService;
import com.wxthxy.supermarket.util.Constants;
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
	
	@RequestMapping("/goodslist.html")
	public String billlist(){
		return "list/goodslist";
		
	}
	@RequestMapping(value = "/json/goodslist",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject billlist(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","");
		json.put("count",goodsservice.getcount());
		List<Goods> goods=goodsservice.goodslist(page-1,limit);
		json.put("data",goods);
		return json;
	}
	@RequestMapping("/goodsadd.html")
	public String goodsadd() {
		return "add/goodsadd";
		
	}
	@RequestMapping("/updategoods.html/{id}")
	public String updategoods(@PathVariable Integer id,HttpServletRequest request) {
		Goods goods = goodsservice.findgoodsbyid(id);
		request.setAttribute("goods",goods);
		return "info/goodsmodify";
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
	public String  deletegoods(@PathVariable Integer id,HttpSession session) {
//		HashMap<String,Object> m = new HashMap<String,Object>();
//		if(id==null||id==""){
//			m.put("delResult", "notexist");
//		}else{
//			Goods goods=goodsservice.findgoodsbyid(id);
//			int count=  goodsservice.deletegoodsbyid(id);
//			Refuse refuse=new Refuse();
//			refuse.setCreateBy(((User)session.getAttribute(Constants.SESSION)).getId());
//			refuse.setCreationDate(new Date());
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//			refuse.setRefCode("TH"+sdf.format(new Date()));
//			refuse.setRefName(goods.getGname());
//			refuse.setRefnumber(goods.getGnumber());
//			refuse.setRefReasion("清空"+goods.getGname()+"的库存");
//			refuse.setRefunit(goods.getGunit());
//			refuseservice.saveRefuse(refuse);
//			if(count>0){
//				m.put("delResult", "true");
//			}else{
//				m.put("delResult", "false");
//			}
//		}
		return null;
	}
	
	
}