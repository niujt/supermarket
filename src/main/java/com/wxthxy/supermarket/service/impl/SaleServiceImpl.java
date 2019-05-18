package com.wxthxy.supermarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.wxthxy.supermarket.dao.SaleDAO;
import com.wxthxy.supermarket.entity.Sale;
import com.wxthxy.supermarket.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Resource
    private SaleDAO saledao;

    public List<Sale> getsaleList(Integer page,Integer limit) {
        return saledao.getsaleList(page,limit);
    }

    public int getcount() {
        return saledao.getcount();
    }

    public int savesale(Sale sale) {
        return saledao.savesale(sale);
    }

    public Sale findsaleByid(String id) {
        return saledao.findsaleByid(id);
    }

    public int deletesalebyid(Integer id) {
        return saledao.deletesalebyid(id);
    }

    public int updatesalebyid(Sale sale) {
        return saledao.updatesalebyid(sale);
    }


}
