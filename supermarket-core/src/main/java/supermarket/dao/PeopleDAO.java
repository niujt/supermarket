package supermarket.dao;

import com.wxthxy.supermarket.entity.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleDAO {
    List<People> getpeopleList();

    List<People> peoplelist(Integer page, Integer limit, String peopleName, Integer deptid);

    int getcount();

    int savepeople(People p);

    People getPeoplebyid(@Param("id") String id);

    int updatepeoplebyid(People p);

    int deletepeoplebyid(@Param("id") Integer id);
}
