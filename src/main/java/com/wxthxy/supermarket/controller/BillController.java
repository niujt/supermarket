package com.wxthxy.supermarket.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Goods;
import com.wxthxy.supermarket.entity.Provider;
import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.BillService;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.ProviderService;
import com.wxthxy.supermarket.service.RefuseService;
import com.wxthxy.supermarket.util.Constants;

/**
 * 订单Controller
 *
 * @author limiaoZhou
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BillService billservice;
    @Autowired
    private ProviderService providerservice;
    @Autowired
    private RefuseService refuseservice;


    @RequestMapping(value = "/bill", method = RequestMethod.GET)
    public JSONObject billlist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit
            , @RequestParam(value = "productName", required = false) String productName, @RequestParam(value = "providerName", required = false) String providerName) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", billservice.getcount());
        List<Bill> bills = billservice.billlist((page - 1) * limit, limit, productName, providerName);
        json.put("data", bills);
        return json;
    }


    /**
     * 进入修改页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
    public JSONObject updatebill(@PathVariable String id, HttpServletRequest request) {
        //根据id查找到订单信息
        Bill b = billservice.getBillbyid(id);
        request.setAttribute("bill", b);
        JSONObject json = new JSONObject();
        //供应商列表
        List<Provider> providerlist = providerservice.getProviderList(0, 9999, "", "");
        json.put("providers", providerlist);
        return json;
    }

    /**
     * 根据id删除订单信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/bill/{id}", method = RequestMethod.DELETE)
    public JSONObject deletebillbyid(@PathVariable String id, HttpSession session) {
        JSONObject json = new JSONObject();
        Bill bill = billservice.getBillbyid(id);
        int count = billservice.deletebillbyid(id);
        if (count > 0) {  //如果删除成功
            Refuse refuse = new Refuse();
            refuse.setCreateBy(((User) session.getAttribute(Constants.SESSION)).getId());
            refuse.setCreationDate(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            refuse.setRefCode("TH" + sdf.format(new Date()));
            refuse.setRefName(bill.getProductName());
            refuse.setRefnumber((bill.getTotalPrice().intValue()) / (bill.getProductCount().intValue()));
            refuse.setRefReasion("取消" + bill.getProductName() + "的订单");
            refuse.setRefunit(bill.getProductUnit());
            refuseservice.saveRefuse(refuse);
            json.put("message", bill.getProductName() + "已删除，已添加到退货单");
        } else {//否则
            json.put("message", "删除失败");
        }

        return json;
    }

    /**
     * 把要添加的订单保存到数据库
     *
     * @param bill
     * @param session
     * @return
     */
    @RequestMapping(value = "/bill", method = RequestMethod.POST)
    public JSONObject savebill(@RequestBody Bill bill, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        bill.setCreatedBy(loginerid);
        //创建时间
        bill.setCreationDate(new Date());
        if (billservice.savebill(bill) == 1) {
            if (bill.getIsin() == 1) {
                saveGoods(bill, loginerid, goodsService);
                json.put("message", bill.getProductName() + "已经添加到库存");
            } else {
                json.put("message", "添加成功");
            }
        } else {
            json.put("message", "添加失败");
        }
        return json;
    }


    /**
     * 点击保存修改的订单信息
     *
     * @param bill
     * @param session
     * @return
     */
    @RequestMapping(value = "/bill", method = RequestMethod.PUT)
    public JSONObject saveupdatebill(@RequestBody Bill bill, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        bill.setModifyBy(loginerid);
        //创建时间
        bill.setModifyDate(new Date());
        if (billservice.updatebillbyid(bill) == 1) {
            if (bill.getIsin() == 1) {
                saveGoods(bill, loginerid, goodsService);
                json.put("message", "修改成功,该商品已入库");
            } else {
                json.put("message", "修改成功");
            }

        } else {
            json.put("message", "修改失败");
        }
        return json;
    }

    private static void saveGoods(Bill bill, Long loginerid, GoodsService goodsService) {
        Goods g = new Goods();
        g.setCreatedBy(loginerid);
        g.setCreationDate(new Date());
        BigDecimal b1 = bill.getTotalPrice();
        BigDecimal b2 = bill.getProductCount();
        g.setGnumber(b1.intValue() / b2.intValue());
        g.setPprice(bill.getProductCount());
        g.setGname(bill.getProductName());
        g.setGunit(bill.getProductUnit());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        g.setGcode("KC" + sdf.format(new Date()));
        goodsService.savegoods(g);
    }
}