package com.wxthxy.supermarket.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.wxthxy.supermarket.dao.ProviderDAO;
import com.wxthxy.supermarket.entity.Provider;
import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.BillDAO;
import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.service.BillService;

@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillDAO billdao;
    @Resource
    private ProviderDAO providerDAO;

    /**
     * 根据条件分页查询订单列表
     */
    public List<Bill> billlist(Integer page, Integer limit, String productName, String providerName) {
        productName = Optional.ofNullable(productName.trim()).orElse("");
        providerName = Optional.ofNullable(providerName.trim()).orElse("");
        Provider provider = Optional.ofNullable(providerDAO.getProviderbyName(providerName)).orElse(new Provider());
        Integer providerId = Optional.ofNullable(provider.getId()).orElse(0);
        if (!providerName.equals("")&&providerId==0) {
            providerId = 99999;
        }
        return billdao.billlist(page, limit, productName, providerId);
    }

    /**
     * 根据条件查询到的总记录数
     */
    public int getcount() {
        return billdao.getcount();
    }

    /**
     * 验证订单编码是否存在
     */
    public boolean CheckbillCode(String billCode) {
        if (billdao.CheckbillCode(billCode) != null) {
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
    public List<Bill> getbillbypproviderid(Integer providerId) {
        return billdao.getbillbypproviderid(providerId);
    }
}
