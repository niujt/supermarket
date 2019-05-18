package com.wxthxy.supermarket.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
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
    public JSONObject userlist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", userservice.getCount());
        List<User> users = userservice.getUserList(page - 1, limit);
        json.put("data", users);
        return json;
    }


    /**
     * 添加用户
     * 先进入到添加用户界面
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/adduser.html", method = RequestMethod.GET)
    public String adduser(@ModelAttribute("user") User user
            , HttpServletRequest request) {
        return "add/useradd";
    }

    /**
     * 单击保存按钮  把要添加 的用户保存到数据库中
     *
     * @param user
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveuser.html", method = RequestMethod.POST)
    public String saveuser(User user
            , HttpSession session
            , HttpServletRequest request) {

        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        user.setCreatedBy(loginerid);
        //创建时间
        user.setCreationDate(new Date());
        if (userservice.adduser(user) == 1) {
            return "redirect:/user/userlist.html";
        }
        return "useradd";
    }

    /**
     * ajax异步验证账号是否存在
     *
     * @param userCode
     * @param request
     * @return
     */
    @RequestMapping("/ucexist")
    @ResponseBody
    public Object userCodeIsExit(@RequestParam String userCode, HttpServletRequest request) {
        // 由于与JSON格式相似的集合为map ，所以声明一个map集合保存json数据
        HashMap<String, String> map = new HashMap<String, String>();
        User user = new User();
        if (StringUtils.isNullOrEmpty(userCode)) {
            map.put("userCode", "exist");
        } else {

            user = userservice.getUserbyuserCode(userCode);
            if (user != null)
                map.put("userCode", "exist");
            else
                map.put("userCode", "noexist");
        }
        return JSON.toJSON(map);
    }

    /**
     * @param uid
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseBody
    public Object view(@RequestParam String uid) {
        User user = null;
        if (uid == null || uid == "") {
            return "nodata";
        } else {

            try {
                user = userservice.getUserbyid(Integer.parseInt(uid));

            } catch (Exception e) {
                e.getStackTrace();
                return "failed";
            }
        }
        return user;
    }


    /**
     * 单击修改按钮进入修改页面并根据id先查询指定的用户信息
     *
     * @param uid
     * @param m
     * @param request
     * @return
     */
    @RequestMapping("/modify.html")
    public String modifyuser(@RequestParam String uid, Model m
            , HttpServletRequest request) {
        User user = new User();
        try {
            user = userservice.getUserbyid(Integer.parseInt(uid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.addAttribute(user);
        return "info/usermodify";
    }

    /**
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/modifysave.html")
    public String modifysaveuser(User user, HttpSession session
    ) {

        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        //修改人
        user.setModifyBy(loginerid);
        //修改日期
        user.setModifyDate(new Date());
        if (userservice.updateuserbyid(user) == 1) {
            return "redirect:/user/userlist.html";
        }

        return "usermodify";
    }


    /**
     * 删除图片
     *
     * @param path
     */
    public void deleteFile(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {  //如果path是一个具体的文件绝对路径
            file.delete();
        } else if (file.isDirectory()) { //如果path是一个文件夹
            String[] filelist = file.list(); //查找该文件夹下的文件或文件夹数组
            for (int i = 0; i < filelist.length; i++) { //循环遍历该数组
                File filessFile = new File(path + "\\" + filelist[i]);
                if (!filessFile.isDirectory()) {
                    filessFile.delete();
                } else if (filessFile.isDirectory()) {
                    deleteFile(path + "//" + filelist[i]);
                }
            }
            file.delete();
        }
    }

    /**
     * 根据id 删除该用户
     *
     * @param userid
     * @param request
     * @return
     */
    @RequestMapping(value = "/deluser", method = RequestMethod.GET)
    @ResponseBody
    public Object deluser(@RequestParam String userid, HttpServletRequest request) {
        HashMap<String, Object> resultmap = new HashMap<String, Object>();

        if (userid == "" || userid == null) {
            resultmap.put("result", "notexist");
        }
        User user = userservice.getUserbyid(Integer.parseInt(userid));
        try {
            if (userservice.DelUserbyId(Integer.parseInt(userid)) > 0) {
                // 判断个人照和工作照是否为空,不为空先删除证件照再删除用户信息,否则直接删除用户信息
            }
        } catch (Exception e) {
            e.getStackTrace();
            resultmap.put("result", "false");
        }
        resultmap.put("result", "true");
        return JSONArray.toJSONString(resultmap);
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
     * 检查旧密码是否相同
     *
     * @param oldpwd
     * @param session
     * @return
     */
    @RequestMapping(value = "/checkoldpass/{oldpwd}", method = RequestMethod.GET)
    @ResponseBody
    public String checkoldpass(@PathVariable String oldpwd, HttpSession session) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        //登陆人的id
        User user = ((User) (session.getAttribute(Constants.SESSION)));
        if (user == null) { //如果没有登录
            result.put("result", "sessionerror");
        } else if (oldpwd.equals("")) { //如果旧密码为空
            result.put("result", "error");
        } else if (!user.getUserPassword().equals(oldpwd)) {//如果输入的旧密码与旧密码不同
            result.put("result", "false");
        } else {
            result.put("result", "true");
        }
        return JSONArray.toJSONString(result);
    }

    /**
     * 保存修改的密码
     *
     * @param
     * @param session
     * @return
     */
    @RequestMapping(value = "/savepass.html",method = RequestMethod.POST)
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


}
