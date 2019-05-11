package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Provider;

public interface ProviderDAO {
    /**
     * 查询所有的供应商信息
     *
     * @return
     */
    List<Provider> providerlist();

    /**
     * 按条件分页查询供应商信息
     *
     * @param proCode  供应商编码
     * @param proName  供应商名称
     * @param from     从(第几页开始)
     * @param pageSize 页面容量
     * @return 供应商列表
     */
    List<Provider> GetProviderList(@Param("proCode") String proCode, @Param("proName") String proName, @Param("from") int from, @Param("pageSize") int pageSize);

    /**
     * 查找符合条件的总记录数
     *
     * @param proCode 供应商编码
     * @param proName 供应商名称
     * @return 查询到的条数
     */
    int GetCount(@Param("proCode") String proCode, @Param("proName") String proName);

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
    Provider getProviderbyid(@Param("id") String id);

    /**
     * 修改供应商
     *
     * @param provider 供应商
     * @return 修改的的条数
     */
    int updateProviderbyid(Provider provider);

    /**
     * 删除供应商
     *
     * @param pid 供应商id
     * @return 删除的条数
     */
    int deleteproviderbyid(@Param("pid") String pid);
}