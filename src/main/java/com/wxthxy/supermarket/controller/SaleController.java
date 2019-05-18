package com.wxthxy.supermarket.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Goods;
import com.wxthxy.supermarket.entity.Sale;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.SaleService;
import com.wxthxy.supermarket.util.Constants;

/**
 * 订单Controller
 *
 * @author Dell
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
    @Resource
    private SaleService saleservice;
    @Resource
    private GoodsService goodsservice;

    @RequestMapping("/salelist.html")
    public String showsalelist() {
        return "list/salelist";
    }

    @RequestMapping(value = "/json/salelist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject showsalelist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", saleservice.getcount());
        List<Sale> sales = saleservice.getsaleList((page - 1) * limit, limit);
        json.put("data", sales);
        return json;
    }

    @RequestMapping("/saleadd.html")
    public String saleadd(HttpServletRequest request) {
        List<Goods> goods = goodsservice.goodslist(0, 99999);
        request.setAttribute("goods", goods);
        return "add/saleadd";
    }

    @RequestMapping("/updatesale.html/{id}")
    public String updatesale(@PathVariable String id, HttpServletRequest request) {
        Sale sale = saleservice.findsaleByid(id);
        request.setAttribute("sale", sale);
        return "info/salemodify";
    }

    @RequestMapping(value = "/deletesalebyid/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deletesale(@PathVariable Integer id) {
        JSONObject json = new JSONObject();
        int count = saleservice.deletesalebyid(id);
        if (count > 0) {
            json.put("message", "删除成功");
        } else {
            json.put("message", "删除失败");
        }
        return json;
    }

    @RequestMapping(value = "/savesale.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject savesale(@RequestBody Sale sale, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        sale.setCreatedBy(loginerid);
        sale.setPprice(goodsservice.findgoodsbygname(sale.getSname()).getPprice());
        //创建时间
        sale.setCreationDate(new Date());
        Goods g = goodsservice.findgoodsbygname(sale.getSname());
        int gnumber = g.getGnumber();
        int snumber = sale.getSnumber();
        if (gnumber - snumber >= 0) {
            saleservice.savesale(sale);
            goodsservice.updategoodsbynumber(snumber, sale.getSname());
            json.put("message", "添加成功,库存中的" + sale.getSname() + "已减少" + sale.getSnumber());
        } else {
            json.put("message", "添加失败,仓库的" + sale.getSname() + "数量不足");
        }
        return json;
    }

    @RequestMapping(value = "/saveupdatesale.html", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject saveupdatesale(@RequestBody Sale sale
            , HttpSession session) {
        JSONObject json = new JSONObject();
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        sale.setModifyBy(loginerid);
        //创建时间
        sale.setModifyDate(new Date());
        if (saleservice.updatesalebyid(sale) == 1) {
           json.put("message","修改成功");
        }
        else {
            json.put("message","修改失败");
        }
        return json;
    }


}