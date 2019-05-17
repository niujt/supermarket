package com.wxthxy.supermarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.RoleDAO;
import com.wxthxy.supermarket.entity.Role;
import com.wxthxy.supermarket.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleDAO  roledao;

	@Override
	public Integer getcount() {
		return roledao.getCount();
	}

	public List<Role> getRolelist(Integer page, Integer limit) {

		return roledao.getRoleList(page, limit);
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
