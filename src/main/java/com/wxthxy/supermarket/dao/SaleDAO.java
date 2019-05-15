package com.wxthxy.supermarket.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.supermarket.entity.Sale;

public interface SaleDAO {
    List<Sale> getsaleList(@Param("scode") String scode, @Param("sname") String sname, @Param("from") int from, @Param("pageSize") int pageSize);

    int getcount(@Param("scode") String scode, @Param("sname") String sname);

    int savesale(Sale sale);

    Sale findsaleByid(@Param("id") String id);

    int deletesalebyid(@Param("id") String id);

    int updatesalebyid(Sale sale);
}