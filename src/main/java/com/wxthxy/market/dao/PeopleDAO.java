package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.People;

public interface PeopleDAO {
	public List<People> getpeopleList();
	public List<People> peoplelist(@Param("peopleName")String peopleName,@Param("deptid")String deptid,@Param("from") int from,@Param("pageSize")int pageSize);
	public int getcount(@Param("peopleName")String peopleName,@Param("deptid")String deptid);
	public int savepeople(People p);
	public People getPeoplebyid(@Param("id")String id);
	public int updatepeoplebyid(People p);
	public int deletepeoplebyid(@Param("id")String id);
}
