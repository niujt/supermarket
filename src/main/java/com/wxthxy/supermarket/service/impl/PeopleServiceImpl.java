package com.wxthxy.supermarket.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.wxthxy.supermarket.dao.DeptDAO;
import com.wxthxy.supermarket.entity.Dept;
import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.PeopleDAO;
import com.wxthxy.supermarket.entity.People;
import com.wxthxy.supermarket.service.PeopleService;
@Service
public class PeopleServiceImpl implements PeopleService{
	@Resource
	public PeopleDAO dao;
	@Resource
	public DeptDAO deptDAO;
	public List<People> peoplelist(Integer page,Integer limit,String peopleName,String dname) {
		peopleName= Optional.ofNullable(peopleName).orElse("");
		dname= Optional.ofNullable(dname).orElse("");
		Dept dept=Optional.ofNullable(deptDAO.finddeptbyname(dname)).orElse(new Dept());
		Integer deptid=Optional.ofNullable(dept.getId()).orElse(0);
		if (!dname.equals("")&&deptid==0) {
			deptid = 99999;
		}
		return dao.peoplelist(page,limit,peopleName,deptid);
	}


	public int getcount() {
		return dao.getcount();
	}


	public int savepeople(People p) {
		return dao.savepeople(p);
		
	}


	public People getPeoplebyid(String id) {
		return dao.getPeoplebyid(id);
	}


	public int updatepeoplebyid(People p) {
		return dao.updatepeoplebyid(p);
		
	}


	public int deletepeoplebyid(Integer id) {
		return dao.deletepeoplebyid(id);
		
	}
	

}
