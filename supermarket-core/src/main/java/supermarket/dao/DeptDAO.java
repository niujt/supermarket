package supermarket.dao;

import com.wxthxy.supermarket.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDAO {
    List<Dept> deptlist();

    Dept finddeptbyname(@Param("dname") String dname);
}