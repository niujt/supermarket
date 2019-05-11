package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Dept;


public interface DeptService {
    List<Dept> deptlist();

    Dept finddeptbyname(String dname);
}
