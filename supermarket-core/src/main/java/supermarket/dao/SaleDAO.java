package supermarket.dao;

import com.wxthxy.supermarket.entity.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleDAO {
    List<Sale> getsaleList(Integer page, Integer limit, String sname, String scode);

    int getcount();

    int savesale(Sale sale);

    Sale findsaleByid(@Param("id") String id);

    int deletesalebyid(@Param("id") Integer id);

    int updatesalebyid(Sale sale);
    List<Sale> findsaleByName(String sname);
}