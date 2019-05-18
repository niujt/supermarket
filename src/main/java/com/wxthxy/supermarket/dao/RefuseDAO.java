package com.wxthxy.supermarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.supermarket.entity.Refuse;

public interface RefuseDAO {
    /**
     * 查询所有退货信息
     *
     * @return
     */
    List<Refuse> refuselist();

    /**
     * 按条件分页查询供应商信息
     *
     * @param
     * @param
     * @return
     */
    List<Refuse> getRefuseList(Integer page,Integer limit);

    /**
     * 查找符合条件的总记录数
     *
     * @param
     * @param
     * @return
     */
    int getCount();

    /**
     * 保存要添加的退货信息信息
     *
     * @param
     * @return
     */
    int saveRefuse(Refuse refuse);

    /**
     * 根据退货信息id查找退货信息
     *
     * @param id
     * @return
     */
    Refuse getRefusebyid(@Param("id") Integer id);

    /**
     * 修改退货信息
     *
     * @param
     * @return
     */
    int updateRefusebyid(Refuse refuse);

    /**
     * 删除退货信息
     *
     * @param id
     * @return
     */
    int deleteRefusebyid(@Param("id") Integer id);
}