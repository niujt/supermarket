package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.market.entity.Sale;

public interface SaleDAO {
	public List<Sale> getsaleList(@Param("scode")String scode,@Param("sname")String sname,@Param("from") int from,@Param("pageSize") int pageSize);

	public int  getcount(@Param ("scode") String scode,@Param("sname")String sname);
	public int savesale(Sale sale);
	public Sale findsaleByid(@Param ("id") String id);
	public int deletesalebyid(@Param ("id") String id);
	public int updatesalebyid(Sale sale);
}