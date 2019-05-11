package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.RoleDAO;
import com.wxthxy.market.entity.Role;
import com.wxthxy.market.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleDAO  roledao;
	public List<Role> getRolelist() {

		return roledao.getCount();
	}
	/**
	 * 添加角色信息
	 */
	public int addrole(Role role) {
		return roledao.addrole(role);
	}
	/**
	 * 按照角色id查找角色信息
	 */
	public Role getrolebyid(String id) {
		return roledao.getrolebyid(id);
	}
	/**
	 * 根据id修改角色信息
	 */
	public int updateole(Role role) {
		return roledao.updateole(role);
	}



}
