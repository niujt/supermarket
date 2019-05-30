package supermarket.controller;

import com.alibaba.fastjson.JSONObject;
import com.wxthxy.supermarket.entity.Role;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.RoleService;
import com.wxthxy.supermarket.util.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleservice;

    //先进入角色页面
    @RequestMapping("/rolelist.html")
    public String getrolelist() {

        return "list/rolelist";
    }

    @RequestMapping(value = "/json/rolelist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject rolelist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", roleservice.getcount());
        List<Role> sales = roleservice.getRolelist((page - 1) * limit, limit);
        json.put("data", sales);
        return json;
    }

    //进入添加角色页面
    @RequestMapping(value = "/addrole.html", method = RequestMethod.GET)
    public String addrole() {

        return "add/roleadd";
    }

    //修改角色信息
    @RequestMapping(value = "/updaterole.html/{id}", method = RequestMethod.GET)
    public String updaterole(@PathVariable String id, HttpServletRequest request) {
        Role r = roleservice.getrolebyid(id);
        request.setAttribute("role", r);
        return "info/rolemodify";
    }

    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteUser(@PathVariable Integer id) {
        JSONObject json = new JSONObject();
        Integer count = roleservice.deleteUser(id);
        if (count > 0) {
            json.put("message", "删除成功");
        } else {
            json.put("message", "删除失败");
        }

        return json;
    }

    //添加角色信息
    @RequestMapping(value = "/saverole.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saverole(@RequestBody Role role, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        role.setCreatedBy(loginerid);
        role.setCreationDate(new Date());
        if (roleservice.addrole(role) > 0) {
            json.put("message", "添加成功");
        } else {
            json.put("message", "添加失败");
        }
        return json;
    }

    //添加角色信息
    @RequestMapping(value = "/saveupdaterole.html", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject saveupdaterole(@RequestBody Role role, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        role.setModifyBy(loginerid);
        role.setModifyDate(new Date());
        if (roleservice.updateole(role) > 0) {
            json.put("message", "修改成功");
        } else {
            json.put("message", "修改失败");
        }
        return json;
    }
}
