package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Sale;


public interface SaleService {
    List<Sale> getsaleList(Integer page,Integer limit);

    int getcount();

    int savesale(Sale sale);

    Sale findsaleByid(String id);

    int deletesalebyid(Integer id);

    int updatesalebyid(Sale sale);
    List<Sale> findsaleByName(String sname);
}
