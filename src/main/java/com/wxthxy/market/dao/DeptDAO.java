package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Dept;

public interface DeptDAO {
    List<Dept> deptlist();

    Dept finddeptbyname(@Param("dname") String dname);
}