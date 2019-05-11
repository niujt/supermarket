package com.wxthxy.market.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
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
import com.wxthxy.market.entity.Dept;
import com.wxthxy.market.entity.Provider;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.BillService;
import com.wxthxy.market.service.DeptService;
import com.wxthxy.market.service.ProviderService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;
/**
 * 订单Controller
 * @author Dell
 *
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private  DeptService deptservice;
	@RequestMapping(value = "/deptlist")
	@ResponseBody
	public Object getproviderlist(){
		HashMap<String,Object> result =new HashMap<String,Object>(); 

		List<Dept> list= deptservice.deptlist();
		if(list!=null){
			result.put("deptlist",list);
		}
		return JSONArray.toJSONString(result);
	}
	
}