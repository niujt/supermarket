package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.UserDAO;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.UserService;
import com.wxthxy.market.util.Constants;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userdao;
	/**
	 * 登录
	 */
	public User login(String userCore) {
		User  user =userdao.selectByPrimaryKey(userCore);
		return user;
	}
	
	
	//根据条件获取总记录数
	public int getCount(String userName, int userRole) {
		return  userdao.getCount(userName, userRole);
	}
	//根据条件分页查询用户信息
	public List<User> getUserList(String userName, int userRole,
			int currentPageNo, int pageSize) {	   
		return  userdao.getUserList(userName, userRole, currentPageNo, pageSize);
	}
	//添加一条新的用户信息
	public int adduser(User u) {
		return userdao.adduser(u);
	}
	//按照id 查询某个用户
	public User getUserbyid(int id){
		return userdao.getUserbyid(id);
	}
	//通过userCode 查询用户
	public User getUserbyuserCode(@Param("userCode")String userCode){
		return userdao.getUserbyuserCode(userCode);
	}
	//根据用户id删除用户信息
	public int DelUserbyId(int id) {
		return userdao.DelUserbyId(id);
	}
	//根据id修改�?个用户信�?
	public int updateuserbyid(User user ){
		 return userdao.updateuserbyid(user);
	}
	//根据登录用户名修改密�?
	public int updatepassbyid(User user) {
		return userdao.updatepassbyid(user);
	}


}
