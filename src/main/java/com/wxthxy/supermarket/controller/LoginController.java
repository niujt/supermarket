package com.wxthxy.supermarket.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.UserService;
import com.wxthxy.supermarket.util.Constants;

@Controller
public class LoginController {

	@Resource
	private UserService userService;
	
	/**
	 * 登录
	 * @return login.jsp
	 */
	@RequestMapping("/login.html")
	public String login(){
		return "login";
	}
	/**
	 * 验证登陆
	 * @param userCode 用户编码
	 * @param userPassword 密码
	 *  @param userCode 权限
	 * @param session 
	 * @param request
	 * @return login.jsp
	 */
	@RequestMapping("/doLogin.html")
	public String doLogin(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,@RequestParam("userRole")String userRole,
			HttpSession  session, HttpServletRequest request){
		Long _userRole=Long.valueOf(userRole);
		String error="";
		User user = userService.login(userCode);
		if(user!=null){
			session.setAttribute(Constants.SESSION, user);
			if(!userPassword.equals(user.getUserPassword())) {
				error="密码错误";
				request.setAttribute("error",error);
				return "login";
			}
			else {
				if(_userRole!=user.getUserRole()) {
					error="权限错误";
					request.setAttribute("error",error);
					return "login";
				}
			}
			return "index";
			}
		else {
			error="用户名不存在或不能为空";
			request.setAttribute("error",error);
			return "login";
		}
		
	}
	
	
	/*主页页面  head.jsp*/
	
	/**
	 * 退出系统——清空session回话
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/outLogin.html",method = RequestMethod.GET)
	public String outLogin(HttpSession  session){
		session.removeAttribute(Constants.SESSION);
		return "login";
	}
}
