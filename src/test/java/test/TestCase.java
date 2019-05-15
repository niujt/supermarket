package test;


import java.math.BigDecimal;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wxthxy.supermarket.dao.DeptDAO;
import com.wxthxy.supermarket.dao.GoodsDAO;
import com.wxthxy.supermarket.dao.PeopleDAO;
import com.wxthxy.supermarket.dao.RefuseDAO;
import com.wxthxy.supermarket.dao.SaleDAO;
import com.wxthxy.supermarket.dao.UserDAO;
import com.wxthxy.supermarket.entity.Goods;
import com.wxthxy.supermarket.entity.People;
import com.wxthxy.supermarket.entity.Refuse;
import com.wxthxy.supermarket.service.GoodsService;
import com.wxthxy.supermarket.service.RefuseService;
import com.wxthxy.supermarket.service.SaleService;
import com.wxthxy.supermarket.service.UserService;
import com.wxthxy.supermarket.service.impl.RefuseServiceImpl;


public class TestCase {
	ApplicationContext ac;
	private GoodsDAO dao;
	private RefuseService service;
	@Before
	public void init(){
		ac=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
	}
	@Test
    public void test01(){
		service=ac.getBean("refuseService",RefuseService.class);
		//Goods g=dao.findgoodsbygname("伊利优酸乳");
		//Long l=new Long(2);
		System.out.println(service.getRefusebyid("8"));
		//System.out.println(service.getsaleList("Z", "猪", 0, 5));
	}
}
