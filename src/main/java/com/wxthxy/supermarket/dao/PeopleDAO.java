package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.People;

public interface PeopleDAO {
    List<People> getpeopleList();

    List<People> peoplelist(@Param("peopleName") String peopleName, @Param("deptid") String deptid, @Param("from") int from, @Param("pageSize") int pageSize);

    int getcount(@Param("peopleName") String peopleName, @Param("deptid") String deptid);

    int savepeople(People p);

    People getPeoplebyid(@Param("id") String id);

    int updatepeoplebyid(People p);

    int deletepeoplebyid(@Param("id") String id);
}
