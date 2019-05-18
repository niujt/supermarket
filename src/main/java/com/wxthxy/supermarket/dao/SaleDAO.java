package com.wxthxy.supermarket.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.supermarket.entity.Sale;

public interface SaleDAO {
    List<Sale> getsaleList(Integer page,Integer limit);

    int getcount();

    int savesale(Sale sale);

    Sale findsaleByid(@Param("id") String id);

    int deletesalebyid(@Param("id") Integer id);

    int updatesalebyid(Sale sale);
}