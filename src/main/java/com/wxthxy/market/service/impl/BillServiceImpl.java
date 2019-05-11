package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.BillDAO;
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.service.BillService;

@Service("billService")
public class BillServiceImpl implements BillService{

	@Resource
	private BillDAO billdao;
	/**
	 * 根据条件分页查询订单列表
	 */
	public List<Bill> billlist(String billCode, int providerId, int isPayment,
			int from, int pageSize) {

		return billdao.billlist(billCode, providerId, isPayment, from, pageSize);
	}
	/**
	 * 根据条件查询到的总记录数
	 */
	public int getcount(String productName, int providerId, int isPayment) {
		return billdao.getcount(productName, providerId, isPayment);
	}
	/**
	 * 验证订单编码是否存在
	 */
	public boolean CheckbillCode(String billCode) {
		if(billdao.CheckbillCode(billCode)!=null){
			return true;
		}
		return false;
	}
	/**
	 * 保存要添加的订单
	 */
	public int savebill(Bill bill) {
		return billdao.savebill(bill);
	}
	/**
	 * 根据id查询订单信息
	 */
	public Bill getBillbyid(String id) {
		return billdao.getBillbyid(id);
	}
	/**
	 * 根据id修改订单信息
	 */
	public int updatebillbyid(Bill bill) {
		return billdao.updatebillbyid(bill);
	}
	/**
	 * 根据id删除订单信息
	 */
	public int deletebillbyid(String id) {
		return billdao.deletebillbyid(id);
	}
	/**
	 * 根据供应商id 查询  订单集合
	 */
	public List<Bill> getbillbypproviderid(String pid) {
		return billdao.getbillbypproviderid(pid);
	}

}
