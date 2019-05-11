package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.BillDAO;
import com.wxthxy.market.dao.DeptDAO;
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Dept;
import com.wxthxy.market.service.BillService;
import com.wxthxy.market.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Resource
	private DeptDAO deptdao;

	@Override
	public List<Dept> deptlist() {
		return deptdao.deptlist();
	}

	@Override
	public Dept finddeptbyname(String dname) {
		
		return deptdao.finddeptbyname(dname);
	}
	
}
