package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.wxthxy.market.dao.SaleDAO;
import com.wxthxy.market.entity.Sale;
import com.wxthxy.market.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Resource
    private SaleDAO saledao;

    public List<Sale> getsaleList(String scode, String sname, int from, int pageSize) {
        return saledao.getsaleList(scode, sname, from, pageSize);
    }

    public int getcount(String scode, String sname) {
        return saledao.getcount(scode, sname);
    }

    public int savesale(Sale sale) {
        return saledao.savesale(sale);
    }

    public Sale findsaleByid(String id) {
        return saledao.findsaleByid(id);
    }

    public int deletesalebyid(String id) {
        return saledao.deletesalebyid(id);
    }

    public int updatesalebyid(Sale sale) {
        return saledao.updatesalebyid(sale);
    }


}
