package com.wxthxy.supermarket.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.RoleService;
import com.wxthxy.supermarket.service.UserService;
import com.wxthxy.supermarket.util.Constants;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userservice;
    @Resource
    private RoleService roleservice;

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping(value = "/userlist.html")
    public String showuserlist() {
        return "list/userlist";
    }

    @RequestMapping(value = "/json/userlist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject userlist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit,
                               @RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "userRoleName", required = false) String userRoleName) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", userservice.getCount());
        List<User> users = userservice.getUserList((page - 1) * limit, limit,userName,userRoleName);
        json.put("data", users);
        return json;
    }

    /**
     * 单击修改按钮进入修改页面并根据id先查询指定的用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/modifyuser.html/{id}")
    public String modifyuser(@PathVariable Integer id, HttpServletRequest request) {
        User user = userservice.getUserbyid(id);
        request.setAttribute("role", roleservice.getRolelist(0, 9999));
        request.setAttribute("user", user);
        return "info/usermodify";
    }

    /**
     * 保存修改的密码
     *
     * @param
     * @param session
     * @return
     */
    @RequestMapping(value = "/savepass.html", method = RequestMethod.POST)
    public String savepass(User newUser, HttpSession session, HttpServletRequest request) {
        User user = ((User) (session.getAttribute(Constants.SESSION)));
        String message = "";
        newUser.setModifyBy(user.getId());
        newUser.setModifyDate(new Date());
        newUser.setUserPassword(newUser.getNewpassword());
        if (!newUser.getOldpassword().equals(user.getUserPassword())) {
            message = "原密码错误";
            request.setAttribute("message", message);
            request.setAttribute("user", user);
            return "info/pwdmodify";
        } else if (userservice.updatepassbyid(newUser) == 1) {
            return "redirect:/login.html";
        } else {
            return "redirect:/user/updatepass.html";
        }

    }

    /**
     * 修改密码
     * 先进入修改页面
     *
     * @return
     */
    @RequestMapping(value = "/updatepass.html", method = RequestMethod.GET)
    public String updatepass(HttpSession session, HttpServletRequest request) {
        User user = ((User) (session.getAttribute(Constants.SESSION)));
        request.setAttribute("user", user);
        return "info/pwdmodify";
    }

    /**
     * 添加用户
     * 先进入到添加用户界面
     *
     * @return
     */
    @RequestMapping(value = "/adduser.html", method = RequestMethod.GET)
    public String adduser(HttpServletRequest request) {
        request.setAttribute("role", roleservice.getRolelist(0, 9999));
        return "add/useradd";
    }

    /**
     * 根据id 删除该用户
     *
     * @return
     */
    @RequestMapping(value = "/deluser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deluser(@PathVariable Integer id) {
        JSONObject json = new JSONObject();
        if (userservice.delUserbyId(id) > 0) {
            json.put("message", "删除成功");
        } else {
            json.put("message", "删除失败");
        }
        return json;
    }

    /**
     * 单击保存按钮  把要添加 的用户保存到数据库中
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveuser.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saveuser(@RequestBody User user, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        user.setCreatedBy(loginerid);
        //创建时间
        user.setCreationDate(new Date());
        if (userservice.adduser(user) == 1) {
            json.put("message", "添加成功");
        } else {
            json.put("message", "添加失败");
        }
        return json;
    }


    /**
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/modifysave.html", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject modifysaveuser(@RequestBody User user, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        //修改人
        user.setModifyBy(loginerid);
        //修改日期
        user.setModifyDate(new Date());
        if (userservice.updateuserbyid(user) == 1) {
            json.put("message", "修改成功");
        } else {
            json.put("message", "修改失败");
        }
        return json;
    }


}
