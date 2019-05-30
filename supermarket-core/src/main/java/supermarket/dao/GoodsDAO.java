package supermarket.dao;

import com.wxthxy.supermarket.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDAO {
    List<Goods> goodslist(Integer page, Integer limit, String gcode, String gname);

    int getcount();

    int savegoods(Goods g);

    int updategoodsbyid(Goods g);

    Goods findgoodsbyid(@Param("id") Integer id);

    int deletegoodsbyid(@Param("id") Integer id);

    int updategoodsbynumber(@Param("gnumber") int gnumber, @Param("gname") String gname);
    int addgoods(Goods goods);
    List<Goods> findgoodsbygname(@Param("gname") String gname);

    int deletegoodsbydname(@Param("gname") String gname);
}