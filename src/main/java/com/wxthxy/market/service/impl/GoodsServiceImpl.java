package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.BillDAO;
import com.wxthxy.market.dao.GoodsDAO;
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;
import com.wxthxy.market.service.BillService;
import com.wxthxy.market.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private GoodsDAO goodsdao;

	@Override
	public List<Goods> getgoodsList(String gcode, String gname,int from,int pageSize) {
		return goodsdao.getgoodsList(gcode, gname, from, pageSize);
	}

	@Override
	public int getcount(String gcode, String gname) {
		return goodsdao.getcount(gcode, gname);
	}

	@Override
	public int savegoods(Goods g) {
		return goodsdao.savegoods(g);
	}

	@Override
	public int updategoodsbyid(Goods g) {
		
		return goodsdao.updategoodsbyid(g);
	}

	@Override
	public Goods findgoodsbyid(String id) {
		
		return goodsdao.findgoodsbyid(id);
	}

	@Override
	public int deletegoodsbyid(String id) {
		return goodsdao.deletegoodsbyid(id);
	}

	@Override
	public List<Goods> goodslist() {
		
		return goodsdao.goodslist();
	}

	@Override
	public int updategoodsbynumber(int gnumber, String sname) {
		
		return goodsdao.updategoodsbynumber(gnumber, sname);
	}

	@Override
	public Goods findgoodsbygname(String gname) {
		
		return goodsdao.findgoodsbygname(gname);
	}

	@Override
	public int deletegoodsbydname(String gname) {
		return goodsdao.deletegoodsbydname(gname);
	}

	@Override
	public int updategoodsbynumber2(int gnumber, String sname) {
		return goodsdao.updategoodsbynumber2(gnumber, sname);
	}

	@Override
	public int updategoodsbynumber3(int gnumber, String sname) {
		return goodsdao.updategoodsbynumber3(gnumber, sname);
	}
	

}
