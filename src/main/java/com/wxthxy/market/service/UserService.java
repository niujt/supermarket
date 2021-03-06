package com.wxthxy.market.service;

import java.util.List;

import com.wxthxy.market.entity.User;

public interface UserService {

    /**
     * 登录
     *
     * @param userCore 用户编码
     * @return 用户
     */
    User login(String userCore);

    /**
     * 根据条件获取总记录数
     *
     * @param userName 用户名
     * @param userRole 用户权限
     * @return 总记录数
     */
    int getCount(String userName, int userRole);

    /**
     * 分页条件查询用户列表
     *
     * @param userName      用户名
     * @param userRole      用户权限
     * @param currentPageNo 当前页码
     * @param pageSize      页面容量
     * @return 用户列表
     */
    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);

    /**
     * 添加一条新的用户信息
     *
     * @param u 用户
     * @return 添加的条数
     */
    int adduser(User u);

    /**
     * 按照id 查询某个用户
     *
     * @param id 用户id
     * @return 用户
     */
    User getUserbyid(int id);

    /**
     * 通过userCode 查询用户
     *
     * @param userCode 用户编码
     * @return 用户
     */
    User getUserbyuserCode(String userCode);

    /**
     * 根据id删除一个用户信息
     *
     * @param id 用户id
     * @return 删除的条数
     */
    int DelUserbyId(int id);

    /**
     * 根据id修改一个用户信息
     *
     * @param user 用户
     * @return 修改的条数
     */
    int updateuserbyid(User user);

    /**
     * 修改登录用户的密码
     *
     * @param user 用户
     * @return 修改的条数
     */
    int updatepassbyid(User user);

}
