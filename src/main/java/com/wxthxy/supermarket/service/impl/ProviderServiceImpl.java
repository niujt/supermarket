package com.wxthxy.supermarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.ProviderDAO;
import com.wxthxy.supermarket.entity.Provider;
import com.wxthxy.supermarket.service.ProviderService;
@Service
public class ProviderServiceImpl implements ProviderService {

	@Resource
	private ProviderDAO providerdao;
	/**
	 * /查询所有的供应商信息
	 */
	public List<Provider> providerlist() {
		return  providerdao.providerlist();
	}
	/**
	 * 根据条件分页查询用户信息
	 */
	public List<Provider> getProviderList(Integer page,Integer limit) {
		return  providerdao.getProviderList(page,limit);
	}
	/**
	 * 查找符合条件的总记录数
	 */
	public int getCount() {
		return providerdao.getCount();
	}
	/**
	 * 保存要添加的供应商信息
	 */
	public int saveprovider(Provider provider) {
		return providerdao.saveprovider(provider);
	}
	/**
	 * 根据供应商id查找供应商
	 */
	public Provider getProviderbyid(Integer id) {
		return providerdao.getProviderbyid(id);
	}
	/**
	 * 修改供应商
	 */
	public int updateProviderbyid(Provider provider) {
	
		return providerdao.updateProviderbyid(provider);
	}
	/**
	 * 删除供应商
	 */
	public int deleteproviderbyid(Integer id) {
	
		return providerdao.deleteproviderbyid(id);
	}
}
