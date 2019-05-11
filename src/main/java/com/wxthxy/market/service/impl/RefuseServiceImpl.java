package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.RefuseDAO;
import com.wxthxy.market.entity.Refuse;
import com.wxthxy.market.service.RefuseService;
@Service("refuseService")
public class RefuseServiceImpl implements RefuseService {

	@Resource
	private RefuseDAO refusedao;
	@Override
	public List<Refuse> Refuselist() {
		
		return refusedao.refuselist();
	}
	@Override
	public List<Refuse> GetRefuseList(String refName,String refCode, int from, int pageSize) {
		return refusedao.GetRefuseList(refName,refCode, from, pageSize);
	}

	@Override
	public int GetCount(String refCode,String refName) {
		return refusedao.GetCount(refCode,refName);
	}

	@Override
	public int saveRefuse(Refuse refuse) {
		return refusedao.saveRefuse(refuse);
	}

	@Override
	public Refuse getRefusebyid(String id) {
		return refusedao.getRefusebyid(id);
	}

	@Override
	public int updateRefusebyid(Refuse refuse) {
		return refusedao.updateRefusebyid(refuse);
	}

	@Override
	public int deleteRefusebyid(String id) {
		return refusedao.deleteRefusebyid(id);
	}
}
