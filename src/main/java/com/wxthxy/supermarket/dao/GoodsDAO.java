package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Goods;

public interface GoodsDAO {
    List<Goods> goodslist(Integer page,Integer limit);

    int getcount();

    int savegoods(Goods g);

    int updategoodsbyid(Goods g);

    Goods findgoodsbyid(@Param("id") Integer id);

    int deletegoodsbyid(@Param("id") String id);

    int updategoodsbynumber(@Param("gnumber") int gnumber, @Param("sname") String sname);

    int updategoodsbynumber2(@Param("gnumber") int gnumber, @Param("sname") String sname);

    int updategoodsbynumber3(@Param("gnumber") int gnumber, @Param("sname") String sname);

    Goods findgoodsbygname(@Param("gname") String gname);

    int deletegoodsbydname(@Param("gname") String gname);
}