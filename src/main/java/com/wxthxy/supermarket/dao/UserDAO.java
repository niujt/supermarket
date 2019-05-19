package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.User;

public interface UserDAO {
    /**
     * 登录
     *
     * @param userCore 用户编码
     * @return 用户
     */
    User selectByPrimaryKey(@Param("userCore") String userCore);

    /**
     * 查询指定条件的记录数
     *
     * @return 查询的条数
     */
    int getCount();

    /**
     * 根据条件获取分页查询的用户信息
     *
     * @return 用户列表
     */
    List<User> getUserList(Integer page,Integer limit,String userName,Integer userRole);

    /**
     * 添加一条用户信息
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
    User getUserbyid(@Param("id") int id);

    /**
     * 通过userCode 查询用户
     *
     * @param userCode 用户编码
     * @return 用户
     */
    User getUserbyuserCode(@Param("userCode") String userCode);

    /**
     * 根据id删除一个用户信息
     *
     * @param id 用户id
     * @return 删除的条数
     */
    int delUserbyId(@Param("id") int id);

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

    List<User> userList();


}