package supermarket.service;

import org.apache.ibatis.annotations.Param;
import supermarket.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 获取所有的角色列表
     *
     * @return 所有角色的列表
     */
    Integer getcount();
    List<Role> getRolelist(Integer page, Integer limit);

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
    Integer deleteUser(Integer id);
}
