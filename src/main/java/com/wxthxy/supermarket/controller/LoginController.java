package com.wxthxy.supermarket.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.UserService;
import com.wxthxy.supermarket.util.Constants;

@Controller
public class LoginController {

	@Resource
	private UserService userService;
	
	/**
	 * 主页面
	 * @return frame.jsp
	 */
	@RequestMapping("/sys/user/main.html")
	public String main(HttpSession session){
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "frame";
		}
		return "user/frame";
	}
	
	/**
	 * 登录
	 * @return login.jsp
	 */
	@RequestMapping("/login.html")
	public String login(){
		return "login1";
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
		System.out.println("====================================role==="+_userRole);
		User user = userService.login(userCode);
		if(user!=null){
			session.setAttribute(Constants.SESSION, user);
			if(!userPassword.equals(user.getUserPassword())) {
				error="密码错误";
				request.setAttribute("error",error);
				return "login1";
			}
			else {
				if(_userRole!=user.getUserRole()) {
					error="权限错误";
					request.setAttribute("error",error);
					return "login1";
				}
			}
			return "redirect:/sys/user/main.html";
			}
		else {
			error="用户名不存在或不能为空";
			request.setAttribute("error",error);
			return "login1";
		}
		
	}
	
	
	/*主页页面  head.jsp*/
	
	/**
	 * 退出系统——清空session回话
	 * @param session
	 * @return
	 */
	@RequestMapping("/sys/user/outLogin.html")
	public String outLogin(HttpSession  session){
		session.removeAttribute(Constants.SESSION);
		return "login1";
	}
	
	/**
	 * 左侧栏
	 * @return
	 */
	@RequestMapping("/sys/user/userlist.html")
	public String userMange(){
		return "userlist";
	}
}
