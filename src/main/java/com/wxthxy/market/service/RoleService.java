package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxthxy.market.entity.Role;

public interface RoleService {
    /**
     * 获取所有的角色列表
     *
     * @return 所有角色的列表
     */
    List<Role> getRolelist();

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
     * @return 更新的条数
     */
    int updateole(Role role);
}
