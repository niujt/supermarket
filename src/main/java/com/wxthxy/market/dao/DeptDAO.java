package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Dept;

public interface DeptDAO {
	public List<Dept> deptlist();
	public Dept finddeptbyname(@Param("dname")String dname);
}