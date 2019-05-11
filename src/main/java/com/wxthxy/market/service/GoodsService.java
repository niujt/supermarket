package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;



public interface GoodsService {
	public List<Goods> getgoodsList(String gcode,String gname,int from,int pageSize);
	public List<Goods> goodslist();
	public int getcount(String gcode,String gname);
	public int savegoods(Goods g);
	public int updategoodsbyid(Goods g);
	public Goods findgoodsbyid(String id);
	public int deletegoodsbyid(String id);
	public int updategoodsbynumber(int gnumber,String sname);
	public int updategoodsbynumber2(int gnumber,String sname);
	public int updategoodsbynumber3(int gnumber,String sname);
	public Goods findgoodsbygname(String gname);
	public int deletegoodsbydname(String gname);
}
