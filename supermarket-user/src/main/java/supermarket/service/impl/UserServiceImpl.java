package supermarket.service.impl;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import supermarket.dao.RoleDAO;
import supermarket.dao.UserDAO;
import supermarket.entity.Role;
import supermarket.entity.User;
import supermarket.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userdao;
    @Resource
    private RoleDAO roleDAO;

    /**
     * 登录
     */
    public User login(String userCore) {
        User user = userdao.selectByPrimaryKey(userCore);
        return user;
    }


    //根据条件获取总记录数
    public int getCount() {
        return userdao.getCount();
    }

    //根据条件分页查询用户信息
    public List<User> getUserList(Integer page, Integer limit, String userName, String userRoleName) {
        userName = Optional.ofNullable(userName).orElse("");
        userRoleName = Optional.ofNullable(userRoleName).orElse("");
        Role role = Optional.ofNullable(roleDAO.getRolebyName(userRoleName)).orElse(new Role());
        Integer userRole = Optional.ofNullable(role.getId()).orElse(0);
        if (!userRoleName.equals("") && userRole == 0) {
            userRole = 99999;
        }
        return userdao.getUserList(page, limit, userName, userRole);
    }

    //添加一条新的用户信息
    public int adduser(User u) {
        return userdao.adduser(u);
    }

    //按照id 查询某个用户
    public User getUserbyid(int id) {
        return userdao.getUserbyid(id);
    }

    //通过userCode 查询用户
    public User getUserbyuserCode(@Param("userCode") String userCode) {
        return userdao.getUserbyuserCode(userCode);
    }

    //根据用户id删除用户信息
    public int delUserbyId(int id) {
        return userdao.delUserbyId(id);
    }

    //根据id修改�?个用户信�?
    public int updateuserbyid(User user) {
        return userdao.updateuserbyid(user);
    }

    //根据登录用户名修改密�?
    public int updatepassbyid(User user) {
        return userdao.updatepassbyid(user);
    }


}
