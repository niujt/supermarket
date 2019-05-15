package com.wxthxy.supermarket.controller;

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
import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Dept;
import com.wxthxy.supermarket.entity.Provider;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.BillService;
import com.wxthxy.supermarket.service.DeptService;
import com.wxthxy.supermarket.service.ProviderService;
import com.wxthxy.supermarket.util.Constants;
import com.wxthxy.supermarket.util.PageSupport;
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