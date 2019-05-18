package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.People;

public interface PeopleDAO {
    List<People> getpeopleList();

    List<People> peoplelist(Integer page,Integer limit);

    int getcount();

    int savepeople(People p);

    People getPeoplebyid(@Param("id") String id);

    int updatepeoplebyid(People p);

    int deletepeoplebyid(@Param("id") Integer id);
}
