package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Provider;

public interface ProviderService {
	/**
	 * 查询所有的供应商信息
	 * @return 供应商列表
	 */
	public List<Provider> providerlist();
	/**
	 * 根据条件分页查询用户信息
	 * @param proCode 供应商编码
	 * @param proName 供应商名称
	 * @param from 从（第几页开始）
	 * @param pageSize 页面容量
	 * @return 供应商列表
	 */
	public List<Provider> GetProviderList(String proCode,String proName,int from,int pageSize);
	/**
	 * 查找符合条件的总记录数
	 * @param proCode 供应商编码
	 * @param proName 供应商名称
	 * @return 符合条件的条数
	 */
	public int GetCount(String proCode,String proName);
	/**
	 * 保存要添加的供应商信息
	 * @param provider 供应商
	 * @return 添加的条数
	 */
	public int saveprovider(Provider provider);
	/**
	 * 根据供应商id查找供应商
	 * @param id 供应商id
	 * @return 供应商
	 */
	public Provider getProviderbyid(@Param("id")String id);
	/**
	 * 修改供应商
	 * @param provider 供应商
	 * @return 修改的条数
	 */
	public int updateProviderbyid(Provider provider);
	/**
	 * 删除供应商
	 * @param id 供应商id
	 * @return 删除的条数
	 */
	public int deleteproviderbyid(@Param("id")String id);
}
