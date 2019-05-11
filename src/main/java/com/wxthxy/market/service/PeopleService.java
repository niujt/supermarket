package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.People;

public interface PeopleService {
	public List<People> peoplelist(String peopleName,String deptid,int from,int pageSize);
	public int getcount(String peopleName,String deptid);
	public int savepeople(People p);
	public People getPeoplebyid(@Param("id")String id);
	public int updatepeoplebyid(People p);
	public int deletepeoplebyid(@Param("id")String id);
}
