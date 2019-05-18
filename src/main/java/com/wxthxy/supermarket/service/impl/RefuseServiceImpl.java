package com.wxthxy.supermarket.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxthxy.supermarket.dao.RefuseDAO;
import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.service.RefuseService;
@Service
public class RefuseServiceImpl implements RefuseService {

	@Resource
	private RefuseDAO refusedao;

	public List<Refuse> Refuselist() {
		
		return refusedao.refuselist();
	}

	public List<Refuse> getRefuseList(Integer page,Integer limit,String refCode,String refName) {
		refCode= Optional.ofNullable(refCode).orElse("");
		refName= Optional.ofNullable(refName).orElse("");
		return refusedao.getRefuseList(page,limit,refCode,refName);
	}


	public int getCount() {
		return refusedao.getCount();
	}


	public int saveRefuse(Refuse refuse) {
		return refusedao.saveRefuse(refuse);
	}


	public Refuse getRefusebyid(Integer id) {
		return refusedao.getRefusebyid(id);
	}


	public int updateRefusebyid(Refuse refuse) {
		return refusedao.updateRefusebyid(refuse);
	}


	public int deleteRefusebyid(Integer id) {
		return refusedao.deleteRefusebyid(id);
	}
}
