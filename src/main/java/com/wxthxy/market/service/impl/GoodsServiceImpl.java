package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.BillDAO;
import com.wxthxy.market.dao.GoodsDAO;
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Goods;
import com.wxthxy.market.service.BillService;
import com.wxthxy.market.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDAO goodsdao;


	public List<Goods> getgoodsList(String gcode, String gname,int from,int pageSize) {
		return goodsdao.getgoodsList(gcode, gname, from, pageSize);
	}


	public int getcount(String gcode, String gname) {
		return goodsdao.getcount(gcode, gname);
	}


	public int savegoods(Goods g) {
		return goodsdao.savegoods(g);
	}


	public int updategoodsbyid(Goods g) {
		
		return goodsdao.updategoodsbyid(g);
	}


	public Goods findgoodsbyid(String id) {
		
		return goodsdao.findgoodsbyid(id);
	}


	public int deletegoodsbyid(String id) {
		return goodsdao.deletegoodsbyid(id);
	}


	public List<Goods> goodslist() {
		
		return goodsdao.goodslist();
	}


	public int updategoodsbynumber(int gnumber, String sname) {
		
		return goodsdao.updategoodsbynumber(gnumber, sname);
	}


	public Goods findgoodsbygname(String gname) {
		
		return goodsdao.findgoodsbygname(gname);
	}


	public int deletegoodsbydname(String gname) {
		return goodsdao.deletegoodsbydname(gname);
	}


	public int updategoodsbynumber2(int gnumber, String sname) {
		return goodsdao.updategoodsbynumber2(gnumber, sname);
	}


	public int updategoodsbynumber3(int gnumber, String sname) {
		return goodsdao.updategoodsbynumber3(gnumber, sname);
	}
	

}
