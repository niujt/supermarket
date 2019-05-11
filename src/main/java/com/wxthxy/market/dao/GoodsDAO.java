package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;

public interface GoodsDAO {
	public List<Goods> getgoodsList(@Param("gcode")String gcode,@Param("gname")String gname,@Param("from") int from,@Param("pageSize") int pageSize);
	public List<Goods> goodslist();
	public int getcount(@Param("gcode")String gcode,@Param("gname")String gname);
	public int savegoods(Goods g);
	public int updategoodsbyid(Goods g);
	public Goods findgoodsbyid(@Param("id")String id);
	public int deletegoodsbyid(@Param("id")String id);
	public int updategoodsbynumber(@Param("gnumber")int gnumber,@Param("sname")String sname);
	public int updategoodsbynumber2(@Param("gnumber")int gnumber,@Param("sname")String sname);
	public int updategoodsbynumber3(@Param("gnumber")int gnumber,@Param("sname")String sname);
	public Goods findgoodsbygname(@Param("gname")String gname);
	public int deletegoodsbydname(@Param("gname")String gname);
}