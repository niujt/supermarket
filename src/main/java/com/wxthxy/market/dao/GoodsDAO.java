package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;

public interface GoodsDAO {
    List<Goods> getgoodsList(@Param("gcode") String gcode, @Param("gname") String gname, @Param("from") int from, @Param("pageSize") int pageSize);

    List<Goods> goodslist();

    int getcount(@Param("gcode") String gcode, @Param("gname") String gname);

    int savegoods(Goods g);

    int updategoodsbyid(Goods g);

    Goods findgoodsbyid(@Param("id") String id);

    int deletegoodsbyid(@Param("id") String id);

    int updategoodsbynumber(@Param("gnumber") int gnumber, @Param("sname") String sname);

    int updategoodsbynumber2(@Param("gnumber") int gnumber, @Param("sname") String sname);

    int updategoodsbynumber3(@Param("gnumber") int gnumber, @Param("sname") String sname);

    Goods findgoodsbygname(@Param("gname") String gname);

    int deletegoodsbydname(@Param("gname") String gname);
}