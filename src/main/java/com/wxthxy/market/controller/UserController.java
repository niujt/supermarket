package com.wxthxy.market.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.wxthxy.market.entity.Role;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.RoleService;
import com.wxthxy.market.service.UserService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userservice;
	@Resource
	private RoleService roleservice;
	/**
	 * 按条件分页查询用户列表
	 * @param model
	 * @param username
	 * @param userRole
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value = "/userlist.html")
	public String  showuserlist(Model model
			,@RequestParam(value = "queryname",required= false) String username
			,@RequestParam(value="queryUserRole",required= false)String userRole
			,@RequestParam( value = "pageIndex",required= false) String pageIndex){
		int _userRole =0; //角色id
		List<User> userlist = null;//查询用户的集合
		int pageSize = Constants.pageSize ;//页面容量
		int currentpage=1;  //从第一页开始

		//如果用户名为空  就设置成空字符串
		if(username == null){
			username = "";
		}
		//如果用户角色不为空 或者不为空字符串
		if(userRole != null && !userRole.equals("")){ 
			//就把角色id赋值给当前角色id
			_userRole = Integer.parseInt(userRole);
		}
		if(pageIndex != null){
			try{ 
				//当前页码等于传过来的页码     
				currentpage = Integer.valueOf(pageIndex);
			}catch(NumberFormatException e){
				//否则就跳转到错误页面
				return  "redirect:/user/syserror.html";
			}
		}
		//获取查询到的所有记录数
		int totalCount 	= userservice.getCount(username,_userRole);
		PageSupport pages=new PageSupport();
		pages.setCurrentPageNo(currentpage);//当前页
		pages.setPageSize(pageSize); //页面容量
		pages.setTotalCount(totalCount);//总记录数
		int totalPageCount = pages.getTotalPageCount(); //总页数
		//控制首页和尾页
		if(currentpage < 1){   //如果当前页码小于1 就等于1
			currentpage = 1;
		}else if(currentpage > totalPageCount){ //如果当前页码大于总页数  就等于总页数
			currentpage = totalPageCount;
		}
		userlist = userservice.getUserList(username,_userRole,((currentpage-1)*pageSize), pageSize);
		model.addAttribute("userList", userlist);
		List<Role> roleList = null;
		roleList = roleservice.getRolelist();
		model.addAttribute("roleList", roleList);  //角色列表
		model.addAttribute("user",userlist); 
		model.addAttribute("queryUserName", username);//用于数据回显    用户名
		model.addAttribute("queryUserRole", _userRole); //用于数据回显    角色id
		model.addAttribute("totalPageCount", totalPageCount);// 总页数
		model.addAttribute("totalCount", totalCount); //查找到的总记录数
		model.addAttribute("currentPageNo", currentpage);//当前页码
		return "userlist"; // 转发到userlist.jsp
	}




	/**
	 * 添加用户
	 * 先进入到添加用户界面
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/adduser.html",method = RequestMethod.GET)
	public String adduser(@ModelAttribute("user")User user
			,HttpServletRequest request){
		return "useradd";
	}

	/**
	 * 单击保存按钮  把要添加 的用户保存到数据库中	
	 * @param user
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveuser.html",method = RequestMethod.POST)
	public String saveuser(User user
			,HttpSession session
			,HttpServletRequest request){
	
			//登陆人的id
			long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
			user.setCreatedBy(loginerid);
			//创建时间
			user.setCreationDate( new  Date());
			if(userservice.adduser(user)==1){
				return "redirect:/user/userlist.html";
			}
		return "useradd";
	}

	/**
	 * ajax异步验证账号是否存在
	 * @param userCode
	 * @param request
	 * @return
	 */
	@RequestMapping("/ucexist")
	@ResponseBody
	public Object userCodeIsExit(@RequestParam String userCode,HttpServletRequest request){
		// 由于与JSON格式相似的集合为map ，所以声明一个map集合保存json数据  
		HashMap<String, String> map = new HashMap<String,String>();
		User user = new User();
		if(StringUtils.isNullOrEmpty(userCode)){
			map.put("userCode","exist");
		}else{

			user = userservice.getUserbyuserCode(userCode);
			if(user!=null)
				map.put("userCode","exist");
			else
				map.put("userCode","noexist");
		}
		return JSON.toJSON(map);
	}
	/**
	 * 
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	@ResponseBody
	public Object view(@RequestParam String uid ){
		User user = null;
		if(uid==null || uid==""){
			return "nodata";
		}else{

			try {
				user = userservice.getUserbyid(Integer.parseInt(uid));

			} catch (Exception e) {
				e.getStackTrace();
				return "failed";
			}
		}
		return user;
	}


	/**
	 * 单击修改按钮进入修改页面并根据id先查询指定的用户信息
	 * @param uid
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping("/modify.html")
	public String modifyuser(@RequestParam String uid,Model m 
			,HttpServletRequest request){
		User user = new User();
		try {
			user = userservice.getUserbyid(Integer.parseInt(uid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute(user);
		return "usermodify";
	}
	/**
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/modifysave.html")
	public String modifysaveuser(User user,HttpSession session
			){

		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		//修改人
		user.setModifyBy(loginerid);
		//修改日期
		user.setModifyDate(new  Date());
		if(userservice.updateuserbyid(user)==1){
			return "redirect:/user/userlist.html";
		}

		return "usermodify";
	}
	//点击查看进入查看页面
	//	@RequestMapping("/view.html/{uid}")
	//	public String view (@PathVariable String uid,Model m){
	//		User user= userservice.getUserbyid(Integer.parseInt(uid));
	//		m.addAttribute(user);
	//		return "userview";
	//	}


	/**
	 * 删除图片
	 * @param path
	 */
	public void deleteFile(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {  //如果path是一个具体的文件绝对路径
			file.delete();
		} else if (file.isDirectory()) { //如果path是一个文件夹
			String[] filelist = file.list(); //查找该文件夹下的文件或文件夹数组
			for (int i = 0; i < filelist.length; i++) { //循环遍历该数组
				File filessFile = new File(path + "\\" + filelist[i]);
				if (!filessFile.isDirectory()) { 
					filessFile.delete();
				} else if (filessFile.isDirectory()) {
					deleteFile(path + "//" + filelist[i]);
				}
			}
			file.delete();
		}
	}
	/**
	 * 根据id 删除该用户
	 * @param userid
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/deluser",method= RequestMethod.GET)
	@ResponseBody
	public Object deluser(@RequestParam String userid,HttpServletRequest request){
		HashMap<String,Object> resultmap = new HashMap<String,Object>();

		if(userid=="" ||userid ==null){
			resultmap.put("result", "notexist");
		}
		User user= userservice.getUserbyid(Integer.parseInt(userid));
		try {
			if(userservice.DelUserbyId(Integer.parseInt(userid))>0){
				// 判断个人照和工作照是否为空,不为空先删除证件照再删除用户信息,否则直接删除用户信息
				}
		} catch (Exception e) {
			e.getStackTrace();
			resultmap.put("result", "false");
		}
		resultmap.put("result", "true");
		return JSONArray.toJSONString(resultmap);
	}



	/**
	 * 修改密码
	 * 先进入修改页面 
	 * @return
	 */
	@RequestMapping(value = "/updatepass.html",method=RequestMethod.GET)
	public String updatepass(HttpSession session){
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "pwdmodify";
		}
		return "user/pwdmodify";
	}
	/**
	 * 检查旧密码是否相同
	 * @param oldpwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/checkoldpass/{oldpwd}",method=RequestMethod.GET)
	@ResponseBody
	public String checkoldpass(@PathVariable String oldpwd,HttpSession session){
		HashMap<String,Object>  result = new HashMap<String,Object>();
		//登陆人的id
		User user= ((User)(session.getAttribute(Constants.SESSION)));  
		if(user==null){ //如果没有登录
			result.put("result","sessionerror");
		}else if(oldpwd.equals("")){ //如果旧密码为空
			result.put("result","error");
		} else if(!user.getUserPassword().equals(oldpwd)){//如果输入的旧密码与旧密码不同
			result.put("result","false");
		}else{
			result.put("result","true");
		}
		return  JSONArray.toJSONString(result);
	}

	/**
	 * 保存修改的密码
	 * @param newpassword
	 * @param session
	 * @return
	 */
	@RequestMapping("/savepass.html")
	public String savepass(@Param("rnewpassword") String newpassword,HttpSession session){
		User user= ((User)(session.getAttribute(Constants.SESSION)));
		User updater  =  new User ();
		updater.setModifyBy(user.getId());
		updater.setModifyDate(new Date());
		updater.setUserPassword(newpassword);
		updater.setId(user.getId());
		if( userservice.updatepassbyid(updater)==1){
			return "redirect:/login.html";
		}
		return "pwdmodify";
	}
	
	
	
	
}
