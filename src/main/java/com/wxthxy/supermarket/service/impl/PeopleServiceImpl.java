package com.wxthxy.supermarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.PeopleDAO;
import com.wxthxy.supermarket.entity.People;
import com.wxthxy.supermarket.service.PeopleService;
@Service
public class PeopleServiceImpl implements PeopleService{
	@Resource
	public PeopleDAO dao;

	public List<People> peoplelist(String peopleName, String deptid, int from, int pageSize) {
		
		return dao.peoplelist(peopleName, deptid, from, pageSize);
	}


	public int getcount(String peopleName, String deptid) {
		return dao.getcount(peopleName, deptid);
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


	public int deletepeoplebyid(String id) {
		return dao.deletepeoplebyid(id);
		
	}
	

}
