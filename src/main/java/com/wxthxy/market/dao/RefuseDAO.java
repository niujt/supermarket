package com.wxthxy.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.market.entity.Refuse;

public interface RefuseDAO {
	/**
	 * 查询所有退货信息
	 * @return
	 */
	List<Refuse> refuselist();
	/**
	 * 按条件分页查询供应商信息
	 * @param proCode
	 * @param proName
	 * @param from
	 * @param pageSize
	 * @return
	 */
	public List<Refuse>  GetRefuseList(@Param("refName") String refName,@Param("refCode") String refCode,@Param("from") int from,@Param("pageSize")int pageSize);
	/**
	 * 查找符合条件的总记录数
	 * @param proCode
	 * @param proName
	 * @return
	 */
	public int GetCount(@Param("refCode") String refCode,@Param("refName") String refName);
	/**
	 * 保存要添加的退货信息信息
	 * @param provider
	 * @return
	 */
	public int saveRefuse(Refuse refuse);
	/**
	 * 根据退货信息id查找退货信息
	 * @param id
	 * @return
	 */
	public Refuse getRefusebyid(@Param("id")String id);
	/**
	 * 修改退货信息
	 * @param provider
	 * @return
	 */
	public int updateRefusebyid(Refuse refuse);
	/**
	 * 删除退货信息
	 * @param id
	 * @return
	 */
	public int deleteRefusebyid(@Param("id")String id);
}