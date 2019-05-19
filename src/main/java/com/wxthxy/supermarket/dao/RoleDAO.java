package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.supermarket.entity.Role;

public interface RoleDAO {
    Integer getCount();
    List<Role> getRoleList(Integer page,Integer limit);

    /**
     * 添加角色信息
     *
     * @param role 角色
     * @return 添加的条数
     */
    int addrole(Role role);

    /**
     * 按照角色id查找角色信息
     *
     * @param id 角色id
     * @return 角色
     */
    Role getrolebyid(@Param("id") String id);

    /**
     * 根据id修改角色信息
     *
     * @param role 角色
     * @return 修改的条数
     */
    int updateole(Role role);
    Integer deleteRole(@Param("id")Integer id);
    Role getRolebyName(String roleName);
}