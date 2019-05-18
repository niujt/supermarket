package com.wxthxy.supermarket.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wxthxy.supermarket.entity.Dept;
import com.wxthxy.supermarket.entity.People;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.DeptService;
import com.wxthxy.supermarket.service.PeopleService;
import com.wxthxy.supermarket.util.Constants;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Resource
    private DeptService deptservice;
    @Resource
    private PeopleService peopleservice;

    //进入员工列表页面
    @RequestMapping("/peoplelist.html")
    public String peoplelistshow(HttpServletRequest request) {
        request.setAttribute("depts", deptservice.deptlist());
        return "list/peoplelist";
    }

    @RequestMapping(value = "/json/peoplelist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject peoplelist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit
    ,@RequestParam(value = "peopleName",required = false)String peopleName,@RequestParam(value = "dname",required = false)String dname) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", peopleservice.getcount());
        List<People> peoples = peopleservice.peoplelist((page - 1) * limit, limit,peopleName,dname);
        json.put("data", peoples);
        return json;
    }

    //进入添加供应商列表
    @RequestMapping("/peopleadd.html")
    public String provideradd(HttpServletRequest request) {
        request.setAttribute("depts", deptservice.deptlist());
        return "add/peopleadd";
    }

    //进入修改人事页面
    @RequestMapping("/updatepeople.html/{id}")
    public String peoplemodify(@PathVariable String id, HttpServletRequest request) {
        People people = peopleservice.getPeoplebyid(id);
        List<Dept> deptlist = deptservice.deptlist();
        request.setAttribute("depts", deptlist);
        request.setAttribute("people", people);
        return "info/peoplemodify";
    }

    //根据id删除人事
    @RequestMapping(value = "/deletepeople/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deletepeople(@PathVariable Integer id) {
        JSONObject json = new JSONObject();
        int count = peopleservice.deletepeoplebyid(id);
        if (count > 0) {
            json.put("message", "删除成功");
        } else {
            json.put("message", "删除失败");
        }
        return json;
    }

    @RequestMapping(value = "savepeople.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject savepeopleadd(@RequestBody People people, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        people.setCreatedBy(loginerid);
        people.setCreationDate(new Date());
        if (peopleservice.savepeople(people) == 1) {
            json.put("message", "添加成功");
        } else {
            json.put("message", "添加失败");
        }
        return json;
    }

    //修改员工
    @RequestMapping(value = "/saveupdatepeople", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject savepeoplemodify(@RequestBody People people
            , HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        people.setModifyBy(loginerid);
        //创建时间
        people.setModifyDate(new Date());
        if (peopleservice.updatepeoplebyid(people) == 1) {
            json.put("message", "修改成功");
        } else {
            json.put("message", "修改失败");
        }
        return json;
    }

}
