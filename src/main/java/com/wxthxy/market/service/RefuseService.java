package com.wxthxy.market.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wxthxy.market.entity.Refuse;

public interface RefuseService {
	/**
	 * 查询所有的退货信息
	 * @return
	 */
	public List<Refuse> Refuselist();
	/**
	 * 根据条件分页查询用户信息
	 * @param proCode
	 * @param proName
	 * @param from
	 * @param pageSize
	 * @return
	 */
	public List<Refuse> GetRefuseList(String refName,String refCode,int from,int pageSize);
	/**
	 * 查找符合条件的总记录数
	 * @param proName
	 * @return
	 */
	public int GetCount(String refCode,String refName);
	/**
	 * 保存要添加的退货信息
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
	 * @param refuse
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
