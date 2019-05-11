package com.wxthxy.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.market.dao.RefuseDAO;
import com.wxthxy.market.entity.Refuse;
import com.wxthxy.market.service.RefuseService;
@Service
public class RefuseServiceImpl implements RefuseService {

	@Resource
	private RefuseDAO refusedao;

	public List<Refuse> Refuselist() {
		
		return refusedao.refuselist();
	}

	public List<Refuse> GetRefuseList(String refName,String refCode, int from, int pageSize) {
		return refusedao.GetRefuseList(refName,refCode, from, pageSize);
	}


	public int GetCount(String refCode,String refName) {
		return refusedao.GetCount(refCode,refName);
	}


	public int saveRefuse(Refuse refuse) {
		return refusedao.saveRefuse(refuse);
	}


	public Refuse getRefusebyid(String id) {
		return refusedao.getRefusebyid(id);
	}


	public int updateRefusebyid(Refuse refuse) {
		return refusedao.updateRefusebyid(refuse);
	}


	public int deleteRefusebyid(String id) {
		return refusedao.deleteRefusebyid(id);
	}
}
