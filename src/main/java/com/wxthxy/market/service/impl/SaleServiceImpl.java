package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.wxthxy.market.dao.SaleDAO;
import com.wxthxy.market.entity.Sale;
import com.wxthxy.market.service.SaleService;

@Service("saleService")
public class SaleServiceImpl implements SaleService{

	@Resource
	private SaleDAO saledao;

	@Override
	public List<Sale> getsaleList(String scode, String sname,int from,int pageSize) {
		return saledao.getsaleList(scode, sname, from, pageSize);
	}

	@Override
	public int getcount(String scode, String sname) {
		return saledao.getcount(scode, sname);
	}

	@Override
	public int savesale(Sale sale) {
		
		return saledao.savesale(sale);
	}

	@Override
	public Sale findsaleByid(String id) {
		return saledao.findsaleByid(id);
	}

	@Override
	public int deletesalebyid(String id) {
		
		return saledao.deletesalebyid(id);
	}

	@Override
	public int updatesalebyid(Sale sale) {
		return saledao.updatesalebyid(sale);
	}

	

}
