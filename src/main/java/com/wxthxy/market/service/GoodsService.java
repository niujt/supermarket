package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;


public interface GoodsService {
    List<Goods> getgoodsList(String gcode, String gname, int from, int pageSize);

    List<Goods> goodslist();

    int getcount(String gcode, String gname);

    int savegoods(Goods g);

    int updategoodsbyid(Goods g);

    Goods findgoodsbyid(String id);

    int deletegoodsbyid(String id);

    int updategoodsbynumber(int gnumber, String sname);

    int updategoodsbynumber2(int gnumber, String sname);

    int updategoodsbynumber3(int gnumber, String sname);

    Goods findgoodsbygname(String gname);

    int deletegoodsbydname(String gname);
}
