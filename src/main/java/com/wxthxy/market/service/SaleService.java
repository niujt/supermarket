package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Sale;



public interface SaleService {
	public List<Sale> getsaleList(String scode,String sname,int from,int pageSize);
	public int getcount(String scode,String sname);
	public int savesale(Sale sale);
	public Sale findsaleByid(String id);
	public int deletesalebyid(String id);
	public int updatesalebyid(Sale sale);
}
