package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Bill;



public interface BillService {
	/**
	 * 分页查询订单
	 * @return 订单列表
	 */
	 List<Bill> billlist(Integer page,Integer limit);
	/**
	 * 订单记录数
	 * @return 订单列表
	 */
	 int  getcount();
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
