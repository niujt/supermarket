package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Sale;


public interface SaleService {
    List<Sale> getsaleList(String scode, String sname, int from, int pageSize);

    int getcount(String scode, String sname);

    int savesale(Sale sale);

    Sale findsaleByid(String id);

    int deletesalebyid(String id);

    int updatesalebyid(Sale sale);
}
