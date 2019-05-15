package com.wxthxy.supermarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.BillDAO;
import com.wxthxy.supermarket.dao.DeptDAO;
import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Dept;
import com.wxthxy.supermarket.service.BillService;
import com.wxthxy.supermarket.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDAO deptdao;


    public List<Dept> deptlist() {
        return deptdao.deptlist();
    }

    public Dept finddeptbyname(String dname) {

        return deptdao.finddeptbyname(dname);
    }

}
