package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Provider;

public interface ProviderService {
    /**
     * 查询所有的供应商信息
     *
     * @return 供应商列表
     */
    List<Provider> providerlist();

    /**
     * 根据条件分页查询用户信息
     * @return 供应商列表
     */
    List<Provider> getProviderList(Integer page,Integer limit);

    /**
     * 查找符合条件的总记录数
     * @return 符合条件的条数
     */
    int getCount();

    /**
     * 保存要添加的供应商信息
     *
     * @param provider 供应商
     * @return 添加的条数
     */
    int saveprovider(Provider provider);

    /**
     * 根据供应商id查找供应商
     *
     * @param id 供应商id
     * @return 供应商
     */
    Provider getProviderbyid(Integer id);

    /**
     * 修改供应商
     *
     * @param provider 供应商
     * @return 修改的条数
     */
    int updateProviderbyid(Provider provider);

    /**
     * 删除供应商
     *
     * @param id 供应商id
     * @return 删除的条数
     */
    int deleteproviderbyid(Integer id);
}
