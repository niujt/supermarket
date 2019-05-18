package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.People;

public interface PeopleService {
    List<People> peoplelist(Integer page,Integer limit,String peopleName,String dname);

    int getcount();

    int savepeople(People p);

    People getPeoplebyid(@Param("id") String id);

    int updatepeoplebyid(People p);

    int deletepeoplebyid(Integer id);
}
