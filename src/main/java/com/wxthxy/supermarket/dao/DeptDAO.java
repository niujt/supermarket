package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Dept;

public interface DeptDAO {
    List<Dept> deptlist();

    Dept finddeptbyname(@Param("dname") String dname);
}