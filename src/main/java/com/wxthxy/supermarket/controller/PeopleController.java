package com.wxthxy.supermarket.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Dept;
import com.wxthxy.supermarket.entity.People;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.service.DeptService;
import com.wxthxy.supermarket.service.PeopleService;
import com.wxthxy.supermarket.util.Constants;

@Controller
@RequestMapping("/people")
public class PeopleController {
	@Resource
	private DeptService deptservice;
	@Resource
	private PeopleService  peopleservice;
	//进入员工列表页面
	@RequestMapping("/peoplelist.html")
	public String peoplelistshow(){
		return "list/peoplelist";
	}
	@RequestMapping(value = "/json/peoplelist",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject peoplelist(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","");
		json.put("count",peopleservice.getcount());
		List<People> peoples=peopleservice.peoplelist(page-1, limit);
		json.put("data",peoples);
		return json;
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
