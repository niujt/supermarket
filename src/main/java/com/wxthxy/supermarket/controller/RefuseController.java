package com.wxthxy.supermarket.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.wxthxy.supermarket.entity.Goods;
import com.wxthxy.supermarket.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.RefuseService;
import com.wxthxy.supermarket.util.Constants;

@Controller
@RequestMapping("/refuse")
public class RefuseController {
    //退货单Controller
    @Resource
    private RefuseService refuseservice;
    @Resource
    private GoodsService goodsservice;
    @Autowired
    private BillService billService;

    //进入退货单列表
    @RequestMapping("/refuselist.html")
    public String refuselist() {
        return "list/refuselist";
    }

    @RequestMapping(value = "/json/refuselist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject showproviderlist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit
    ,@RequestParam(value="refCode",required = false)String refCode,@RequestParam(value="refName",required = false)String refName) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", refuseservice.getCount());
        List<Refuse> refuses = refuseservice.getRefuseList((page - 1) * limit, limit,refCode,refName);
        json.put("data", refuses);
        return json;
    }

    //进入添加订单列表
    @RequestMapping("/refuseadd.html")
    public String refuseadd(HttpServletRequest request) {
        List<Goods> goods = goodsservice.goodslist(0, 99999);
        request.setAttribute("goods", goods);
        return "add/refuseadd";
    }

    //进入修改页面
    @RequestMapping(value = "updaterefuse.html/{id}", method = RequestMethod.GET)
    public String updaterefuse(@PathVariable Integer id, HttpServletRequest request) {
        //根据id查找到订单信息
        Refuse r = refuseservice.getRefusebyid(id);
        request.setAttribute("refuse", r);
        return "info/refusemodify";
    }

    //根据id删除订单信息
    @RequestMapping(value = "/deleterefusebyid/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleterefusebyid(@PathVariable Integer id) {
        JSONObject json = new JSONObject();
        int count = refuseservice.deleteRefusebyid(id);
        if (count > 0) {  //如果删除成功
            json.put("message", "删除成功");
        } else {//否则
            json.put("message", "删除失败");
        }
        return json;
    }

    @RequestMapping(value = "/saverefuse.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saverefuse(@RequestBody Refuse refuse, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        refuse.setCreateBy(loginerid);
        //创建时间
        refuse.setCreationDate(new Date());
        if (refuseservice.saveRefuse(refuse) == 1) {
            goodsservice.updategoodsbynumber(refuse.getRefnumber(), refuse.getRefName());
            json.put("message", "删除成功,库存中" + refuse.getRefName() + "已经减少" + refuse.getRefnumber());
        } else {
            json.put("message", "删除失败");
        }
        return json;
    }

    //点击保存修改的订单信息
    @RequestMapping(value = "/saveupdaterefuse.html", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject saveupdaterefuse(@RequestBody Refuse refuse, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        refuse.setModifyBy(loginerid);
        //创建时间
        refuse.setModifyDate(new Date());
        if (refuseservice.updateRefusebyid(refuse) == 1) {
            json.put("message", "修改成功");
        } else {
            json.put("message", "修改失败");
        }
        return json;
    }
}