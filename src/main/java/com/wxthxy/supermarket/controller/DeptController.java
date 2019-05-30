package com.wxthxy.supermarket.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Dept;
import com.wxthxy.supermarket.service.DeptService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单Controller
 * @author limiaoZhou
 *
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private  DeptService deptservice;
	@RequestMapping(value = "/dept",method = RequestMethod.GET)
	public Object getproviderlist(){
		HashMap<String,Object> result =new HashMap<String,Object>(); 

		List<Dept> list= deptservice.deptlist();
		if(list!=null){
			result.put("deptlist",list);
		}
		return JSONArray.toJSONString(result);
	}
	
}