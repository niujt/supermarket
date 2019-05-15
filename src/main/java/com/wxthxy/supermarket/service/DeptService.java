package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Dept;


public interface DeptService {
    List<Dept> deptlist();

    Dept finddeptbyname(String dname);
}
