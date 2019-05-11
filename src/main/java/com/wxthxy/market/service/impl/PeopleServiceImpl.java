package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.PeopleDAO;
import com.wxthxy.market.entity.People;
import com.wxthxy.market.service.PeopleService;
@Service("peopleService")
public class PeopleServiceImpl implements PeopleService{
	@Resource
	public PeopleDAO dao;
	@Override
	public List<People> peoplelist(String peopleName, String deptid, int from, int pageSize) {
		
		return dao.peoplelist(peopleName, deptid, from, pageSize);
	}

	@Override
	public int getcount(String peopleName, String deptid) {
		return dao.getcount(peopleName, deptid);
	}

	@Override
	public int savepeople(People p) {
		return dao.savepeople(p);
		
	}

	@Override
	public People getPeoplebyid(String id) {
		return dao.getPeoplebyid(id);
	}

	@Override
	public int updatepeoplebyid(People p) {
		return dao.updatepeoplebyid(p);
		
	}

	@Override
	public int deletepeoplebyid(String id) {
		return dao.deletepeoplebyid(id);
		
	}
	

}
