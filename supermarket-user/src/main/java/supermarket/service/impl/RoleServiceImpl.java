package supermarket.service.impl;

import org.springframework.stereotype.Service;
import supermarket.dao.RoleDAO;
import supermarket.entity.Role;
import supermarket.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDAO roledao;

	@Override
	public Integer getcount() {
		return roledao.getCount();
	}

	public List<Role> getRolelist(Integer page, Integer limit) {

		return roledao.getRoleList(page, limit);
	}
	/**
	 * 添加角色信息
	 */
	public int addrole(Role role) {
		return roledao.addrole(role);
	}
	/**
	 * 按照角色id查找角色信息
	 */
	public Role getrolebyid(String id) {
		return roledao.getrolebyid(id);
	}
	/**
	 * 根据id修改角色信息
	 */
	public int updateole(Role role) {
		return roledao.updateole(role);
	}

	@Override
	public Integer deleteUser(Integer id) {
		return roledao.deleteRole(id);
	}
}
