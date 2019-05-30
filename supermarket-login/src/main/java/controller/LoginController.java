package controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.LoginService;
import supermarket.entity.User;
import supermarket.util.Constants;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

	@Resource
	private LoginService loginService;
	
	/**
	 * 登录
	 * @return login.jsp
	 */
	@RequestMapping("")
	public String login(){
		return "login";
	}
	@RequestMapping("/index")
	public String index(){
		return "index";
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
		User user = loginService.login(userCode);
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
