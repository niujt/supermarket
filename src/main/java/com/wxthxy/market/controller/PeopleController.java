package com.wxthxy.market.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.market.entity.Bill;
import com.wxthxy.market.entity.Dept;
import com.wxthxy.market.entity.People;
import com.wxthxy.market.entity.Provider;
import com.wxthxy.market.entity.User;
import com.wxthxy.market.service.BillService;
import com.wxthxy.market.service.DeptService;
import com.wxthxy.market.service.PeopleService;
import com.wxthxy.market.service.ProviderService;
import com.wxthxy.market.util.Constants;
import com.wxthxy.market.util.PageSupport;

@Controller
@RequestMapping("/people")
public class PeopleController {
	@Resource
	private DeptService deptservice;
	@Resource
	private PeopleService  peopleservice;
	//进入员工列表页面
	@RequestMapping("/peoplelist.html")
	public String providerlist(Model m ,
			@RequestParam(value = "queryPeopleName",required = false) String peopleName ,
			@RequestParam(value = "querydeptid",required = false) String deptid,
			@RequestParam(value = "pageIndex",required = false) String pageIndex,
			HttpSession session){
		List<People> peopleList = null ;
		
		int  currentpage = 1; //当前页号 从1 开始
		int pageSize = Constants.pageSize; //页面容量
		int _deptid=0;
		if(peopleName==null ){
			peopleName = "";
		}
		if(deptid != null &&deptid.equals("")){
			_deptid=Integer.parseInt(deptid);
		}
		if(pageIndex !=null){
			currentpage = Integer.valueOf(pageIndex);
		}
		int totalCount = peopleservice.getcount(peopleName, deptid);//查找符合条件的总记录数  
		PageSupport ps = new PageSupport();
		ps.setCurrentPageNo(currentpage);
		ps.setPageSize(pageSize);
		ps.setTotalCount(totalCount);
		int pagecount = ps.getTotalPageCount(); //获得总页数
		if(currentpage<1){
			currentpage = 1;
		}else if(currentpage>pagecount){
			currentpage = pagecount;
		}
		peopleList = peopleservice.peoplelist(peopleName,deptid,((currentpage-1)*pageSize), pageSize);
	
		m.addAttribute("peopleList",peopleList);
		//用于数据回显
		m.addAttribute("queryPeopleName",peopleName);
		m.addAttribute("querydeptid",_deptid);
		m.addAttribute("totalPageCount",pagecount);
		m.addAttribute("totalCount", totalCount);
		m.addAttribute("currentPageNo",currentpage);
		Long role=((User)(session.getAttribute(Constants.SESSION))).getUserRole();
		if(role==1) {
			return "peoplelist";
		}
		return "user/peoplelist";
	}
	//进入添加供应商列表
	@RequestMapping("/peopleadd.html")
	public String provideradd(@ModelAttribute People people){
		return "peopleadd";
	}
	//单击添加保存新的供应商信息
	@RequestMapping(value="savepeople.html",method = RequestMethod.POST)
	public String savepeopleadd(People people
			,HttpSession session){

		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		System.out.println("loginerid==========="+loginerid);
		people.setCreatedBy(loginerid);
		people.setCreationDate(new Date());
		if(peopleservice.savepeople(people)==1){
			return "redirect:/people/peoplelist.html";
		}
		return "peopleadd";
	}

	//根据人事id查找人事信息
	@RequestMapping("/view/{id}")
	public String peopleview(@PathVariable String id,Model m){
		People p = new People();
		p = peopleservice.getPeoplebyid(id);
		m.addAttribute("people",p);
		return "peopleview";
	}

	//进入修改人事页面
	@RequestMapping("/updatepeople/{id}")
	public String peoplemodify(@PathVariable String id ,@ModelAttribute People people,Model m,HttpServletRequest request){
		people = peopleservice.getPeoplebyid(id);
		List<Dept> deptlist=deptservice.deptlist();
		m.addAttribute("deptlist",deptlist);
		m.addAttribute("people",people);
		return "peoplemodify";
	}
	//修改员工
	@RequestMapping("/saveupdatepeople")
	public String savepeoplemodify(People people
			,HttpSession session){
		//登陆人的id
		long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();  
		people.setModifyBy(loginerid);
		//创建时间
		people.setModifyDate( new  Date());
		if(peopleservice.updatepeoplebyid(people)==1){
			return "redirect:/people/peoplelist.html";
		}
		return "peopleadd";
	}

	//根据id删除人事
	@RequestMapping("/deletepeople/{id}")
	@ResponseBody
	public Object deletepeople(@PathVariable String id){
		HashMap<String,Object> m = new HashMap<String,Object>();
		if(id==null||id==""){
			m.put("delResult", "notexist");
		}else{
			int count=  peopleservice.deletepeoplebyid(id);
			if(count>0){
				m.put("delResult", "true");
			}else{
				m.put("delResult", "false");
			}
		}
		return JSONArray.toJSONString(m);
	}
}
