package com.wxthxy.supermarket.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.supermarket.entity.Refuse;

public interface RefuseService {
    /**
     * 查询所有的退货信息
     *
     * @return
     */
    List<Refuse> Refuselist();

    /**
     * 根据条件分页查询用户信息
     *
     * @return
     */
    List<Refuse> getRefuseList(Integer page,Integer limit);

    /**
     * 查找符合条件的总记录数
     * @return
     */
    int getCount();

    /**
     * 保存要添加的退货信息
     *
     * @param refuse
     * @return
     */
    int saveRefuse(Refuse refuse);

    /**
     * 根据退货信息id查找退货信息
     *
     * @param id
     * @return
     */
    Refuse getRefusebyid(Integer id);

    /**
     * 修改退货信息
     *
     * @param refuse
     * @return
     */
    int updateRefusebyid(Refuse refuse);

    /**
     * 删除退货信息
     *
     * @param id
     * @return
     */
    int deleteRefusebyid(Integer id);

}
