package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Goods;


public interface GoodsService {
    List<Goods> goodslist(Integer page,Integer limit,String gcode,String gname);

    int getcount();

    int savegoods(Goods g);

    int updategoodsbyid(Goods g);

    Goods findgoodsbyid(Integer id);

    int deletegoodsbyid(Integer id);

    int updategoodsbynumber(int gnumber, String gname);
    int addgoods(Goods g);

    List<Goods> findgoodsbygname(String gname);

    int deletegoodsbydname(String gname);
}
