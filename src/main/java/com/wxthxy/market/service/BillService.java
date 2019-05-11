package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Bill;



public interface BillService {
	/**
	 * 按照条件分页查询订单
	 * @param billCode 订单编码
	 * @param providerId 供应商id
	 * @param isPayment 是否付款
	 * @param from 从(第几页开始)
	 * @param pageSize 页面容量
	 * @return 订单列表
	 */
	 List<Bill> billlist(String billCode,int providerId,int isPayment, int from,int pageSize);
	/**
	 * 按条件查询到的订单记录数
	 * @param productName 商品名称
	 * @param providerId 供应商id
	 * @param isPayment 是否付款
	 * @return 订单列表
	 */
	 int  getcount(String productName,int providerId,int isPayment);
	/**
	 * 验证订单编码是否存在
	 * @param billCode 订单编码
	 * @return true/false
	 */
	 boolean CheckbillCode(@Param("billCode")String billCode);
	/**
	 * 保存要添加的订单
	 * @param bill 订单
	 * @return 保存的条数
	 */
	 int savebill(Bill bill);//根据id查询订单
	/**
	 * 根据id查询订单信息
	 * @param id 订单id
	 * @return 订单
	 */
	 Bill getBillbyid(@Param("id")String id);
	/**
	 * 根据id修改订单信息
	 * @param bill 订单
	 * @return 修改的条数
	 */
	 int updatebillbyid(Bill bill );
	/**
	 * 根据id删除订单信息
	 * @param id 订单id
	 * @return 删除的条数
	 */
	 int deletebillbyid(@Param("id")String id);
	/**
	 * 根据供应商id 查询  订单集合
	 * @param pid 供应商id
	 * @return 订单列表
	 */
	 List<Bill> getbillbypproviderid(@Param("pid")String pid);
}
