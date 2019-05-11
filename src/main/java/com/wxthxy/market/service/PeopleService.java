package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.People;

public interface PeopleService {
    List<People> peoplelist(String peopleName, String deptid, int from, int pageSize);

    int getcount(String peopleName, String deptid);

    int savepeople(People p);

    People getPeoplebyid(@Param("id") String id);

    int updatepeoplebyid(People p);

    int deletepeoplebyid(@Param("id") String id);
}
