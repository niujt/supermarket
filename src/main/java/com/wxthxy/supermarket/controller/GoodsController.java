package com.wxthxy.supermarket.controller;

import java.text.SimpleDateFormat;
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
import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.RefuseService;
import com.wxthxy.supermarket.util.Constants;

/**
 * 库存Controller
 *
 * @author Dell
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsservice;
    @Resource
    private RefuseService refuseservice;

    @RequestMapping("/goodslist.html")
    public String billlist() {
        return "list/goodslist";

    }

    @RequestMapping(value = "/json/goodslist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject billlist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", goodsservice.getcount());
        List<Goods> goods = goodsservice.goodslist((page - 1) * limit, limit);
        json.put("data", goods);
        return json;
    }

    @RequestMapping("/goodsadd.html")
    public String goodsadd() {
        return "add/goodsadd";

    }

    @RequestMapping("/updategoods.html/{id}")
    public String updategoods(@PathVariable Integer id, HttpServletRequest request) {
        Goods goods = goodsservice.findgoodsbyid(id);
        request.setAttribute("goods", goods);
        return "info/goodsmodify";
    }

    @RequestMapping(value = "/deletegoodsbyid/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deletegoods(@PathVariable Integer id, HttpSession session) {
        JSONObject json = new JSONObject();
        Goods goods = goodsservice.findgoodsbyid(id);
        Integer count = goodsservice.deletegoodsbyid(id);
        if (count > 0) {
            Refuse refuse = new Refuse();
            refuse.setCreateBy(((User) session.getAttribute(Constants.SESSION)).getId());
            refuse.setCreationDate(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            refuse.setRefCode("TH" + sdf.format(new Date()));
            refuse.setRefName(goods.getGname());
            refuse.setRefnumber(goods.getGnumber());
            refuse.setRefReasion("清空" + goods.getGname() + "的库存");
            refuse.setRefunit(goods.getGunit());
            refuseservice.saveRefuse(refuse);
            json.put("message", goods.getGname() + "库存已清空");
        } else {
            json.put("message", "删除失败");
        }
        return json;
    }

    @RequestMapping(value = "/savegoods.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject savegoods(@RequestBody Goods goods, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        goods.setCreatedBy(loginerid);
        goods.setCreationDate(new Date());
        if (goodsservice.findgoodsbygname(goods.getGname()) != null && goodsservice.findgoodsbygname(goods.getGname()).getPprice().equals(goods.getPprice())) {
            goodsservice.addgoods(goods);
            json.put("message", "添加成功,"+goods.getGname() + "新增" + goods.getGnumber() + goods.getGunit());
        }
        else if (goodsservice.findgoodsbygname(goods.getGname()) != null && !goodsservice.findgoodsbygname(goods.getGname()).getPprice().equals(goods.getPprice())) {
            json.put("message", "添加"+goods.getGname() +"成功,进价为"+goods.getPprice()+"元");
            goodsservice.savegoods(goods);
        } else {
            goodsservice.savegoods(goods);
            json.put("message", "添加成功");
        }
        return json;
    }

    @RequestMapping("/saveupdategoods")
    public String saveupdategoods(Goods goods
            , HttpSession session) {
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        goods.setModifyBy(loginerid);
        //创建时间
        goods.setModifyDate(new Date());
        if (goodsservice.updategoodsbyid(goods) == 1) {
            return "redirect:/goods/goodslist.html";
        }
        return "goodsadd";
    }


}