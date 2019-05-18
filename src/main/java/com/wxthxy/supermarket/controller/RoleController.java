package com.wxthxy.supermarket.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wxthxy.supermarket.entity.Role;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.RoleService;
import com.wxthxy.supermarket.util.Constants;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleservice;
	//先进入角色页面
	@RequestMapping("/rolelist.html")
	public String getrolelist(){

		return "list/rolelist";
	}
	@RequestMapping(value = "/json/rolelist",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject rolelist(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","");
		json.put("count",roleservice.getcount());
		List<Role> sales=roleservice.getRolelist(page-1,limit);
		json.put("data",sales);
		return json;
	}
	//进入添加角色页面
	@RequestMapping(value = "/addrole.html",method = RequestMethod.GET)
	public String addrole(){

		return "add/roleadd";
	}
	//保存添加角色
	@RequestMapping(value = "/saveaddrole.html")
	public String saveaddrole(Role role ,HttpSession session){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		role.setCreatedBy(loginerid);
		//创建时间
		role.setCreationDate( new  Date());
		if(roleservice.addrole(role)>=1){
			return "redirect:/role/rolelist.html";
		}
		return "roleadd";
	}
	//修改角色信息
	@RequestMapping(value = "/updaterole.html/{id}",method = RequestMethod.GET)
	public String updaterole(@PathVariable String id,@ModelAttribute Role role,Model m){
		Role r =roleservice.getrolebyid(id);
		m.addAttribute("role",r);
		return "rolemodify";
	}
	//保存修改的角色信息
	@RequestMapping(value = "/saveupdaterole.html",method = RequestMethod.POST)
	public String saveupdaterole(Role role ,HttpSession session){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		role.setModifyBy(loginerid);
		//创建时间
		role.setModifyDate(new  Date());
		if(roleservice.updateole(role)>=1){
			return "redirect:/role/rolelist.html";
		}
		return "roleadd";
	}
}
