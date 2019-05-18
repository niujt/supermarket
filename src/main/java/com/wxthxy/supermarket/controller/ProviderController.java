package com.wxthxy.supermarket.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONArray;
import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Provider;
import com.wxthxy.supermarket.service.BillService;
import com.wxthxy.supermarket.service.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	@Resource
	private ProviderService  providerservice;
	@Resource
	private BillService  billservice;
	//进入供应商列表页面
	@RequestMapping("/providerlist.html")
	public String showproviderlist(){

		return "list/providerlist";
	}
	@RequestMapping(value = "/json/providerlist",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject showproviderlist(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","");
		json.put("count",providerservice.getCount());
		List<Provider> providers=providerservice.getProviderList(page-1,limit);
		json.put("data",providers);
		return json;
	}
	//进入添加供应商列表
	@RequestMapping("/provideradd.html")
	public String provideradd(){
		return "add/provideradd";
	}
	//单击添加保存新的供应商信息
	@RequestMapping(value="/saveprovideradd.html",method = RequestMethod.POST)
	public String saveprovideradd(Provider provider
			,HttpSession session
			,HttpServletRequest request
			,@RequestParam(value = "attachs",required = false)MultipartFile[] attachs){
//		String companyLicPicPath = ""; //营业执照
//		String orgCodePicPath = "";//组织机构代码证
//		//设置上传路径
//		String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
//		//设置上传文件的最大字节数；
//		int filesize = 500000;
//		//错误信息出自
//		String errorinfo = "";
//		//设置一个标识符 判断 上船的文件是否出错
//		boolean flag =  true;
//		//循环遍历上传表单标签 的数组
//		for (int i = 0; i<attachs.length ;i++) {
//			MultipartFile attach = attachs[i];
//			//如果上传的工作照片不为空时
//			if(!attach.isEmpty()){
//				if(i==0){
//					errorinfo = "uploadFileError";
//				}else if(i==1){
//					errorinfo = "uploadOcError";
//				}
//				//获取上传文件的原文件名
//				String oldPathName = attach.getOriginalFilename();
//				//获取上传文件的后缀名
//				String prefix = FilenameUtils.getExtension(oldPathName);
//				//先判断文件大小
//				if(attach.getSize()>filesize){ //如果上传文件的大小大于设置的最大字节
//					request.setAttribute(errorinfo,"上传文件过大！");
//					flag=false;
//				}else if(prefix.equalsIgnoreCase("jpg")
//						||prefix.equalsIgnoreCase("png")
//						||prefix.equalsIgnoreCase("jpeg")
//						||prefix.equalsIgnoreCase("pneg")){
//					//如果上传文件满足各条件
//					//设置新的文件名
//					String fileName = System.currentTimeMillis()+RandomUtils.nextInt(10000000)+"_Personal.jpg";
//					//指定文件夹存放上传的图片
//					File targetFile = new File(path,fileName);
//					//如果该文件夹不存在，就重新创建一个
//					if(!targetFile.exists()){
//						targetFile.mkdirs();
//					}
//					//把上传文件保存到新建的文件夹中
//					try {
//						attach.transferTo(targetFile);
//					} catch (Exception e) {
//						request.setAttribute(errorinfo,"上传失败！");
//						flag = false;
//					}
//					//如果保存成功  就把该文件的绝对路径获取出来
//					if(i==0){
//						companyLicPicPath = path+File.separator+fileName;
//					}else if(i==1){
//						orgCodePicPath =  path+File.separator+fileName;
//					}
//
//				}else{ //如果上传文件的后缀不等于指定的这几个
//					request.setAttribute(errorinfo,"上传文件类型不正确！");
//					flag= false;
//				}
//			}
//
//		}
//		if(flag){
//			//登陆人的id
//			long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();
//			provider.setCreatedBy(loginerid);
//			//创建时间
//			provider.setCreationDate( new  Date());
//			//营业执照
//			provider.setCompanyLicPicPath(companyLicPicPath);
//			//组织机构代码证
//			provider.setOrgCodePicPath(orgCodePicPath);
//
//			if(providerservice.saveprovider(provider)==1){
//				return "redirect:/provider/providerlist.html";
//			}
//		}
		return "provideradd";
	}
	//根据供应商id查找供应商信息
	@RequestMapping("/view/{id}")
	public String provicerview(@PathVariable String id,Model m,HttpServletRequest request){
//		Provider p = new Provider();
//		try {
//			p = providerservice.getProviderbyid(id);
//			if(p.getCompanyLicPicPath() != null && !"".equals(p.getCompanyLicPicPath())){
//				String[] paths = p.getCompanyLicPicPath().split("\\"+File.separator);
//				p.setCompanyLicPicPath(request.getContextPath()+"/statics/uploadfiles/"+paths[paths.length-1]);
//			}
//			if(p.getOrgCodePicPath() != null && !"".equals(p.getOrgCodePicPath())){
//				String[] paths = p.getOrgCodePicPath().split("\\"+File.separator);
//				p.setOrgCodePicPath(request.getContextPath()+"/statics/uploadfiles/"+paths[paths.length-1]);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		m.addAttribute("provider",p);
		return "providerview";
	}
	//进入修改供应商页面
	@RequestMapping("/updateprovider/{id}")
	public String providermodify(@PathVariable String id ,@ModelAttribute Provider provider,Model m,HttpServletRequest request){
		Provider p = new Provider();
		try {
			p = providerservice.getProviderbyid(id);
			if(p.getCompanyLicPicPath() != null && !"".equals(p.getCompanyLicPicPath())){
				String[] paths = p.getCompanyLicPicPath().split("/"+File.separator);
				p.setCompanyLicPicPath(request.getContextPath()+"/statics/uploadfiles/"+paths[paths.length-1]);
			}
			if(p.getOrgCodePicPath() != null && !"".equals(p.getOrgCodePicPath())){
				String[] paths = p.getOrgCodePicPath().split("/"+File.separator);
				p.setOrgCodePicPath(request.getContextPath()+"/statics/uploadfiles/"+paths[paths.length-1]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("provider",p);
		return "providermodify";
	}
	//修改供应商
	@RequestMapping("/saveupdateprovider")
	public String saveprovidermodify(Provider provider
			,HttpSession session
			,HttpServletRequest request
			,@RequestParam(value = "attachs",required = false)MultipartFile[] attachs){
		String companyLicPicPath = ""; //营业执照
		String orgCodePicPath = "";//组织机构代码证
		//设置上传路径
		String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
		//设置上传文件的最大字节数；
		int filesize = 500000;
		//错误信息出自
		String errorinfo = "";
		//设置一个标识符 判断 上船的文件是否出错
		boolean flag =  true;
	//	if(attachs!=null){


			//循环遍历上传表单标签 的数组
//			for (int i = 0; i<attachs.length ;i++) {
//				MultipartFile attach = attachs[i];
//				//如果上传的工作照片不为空时
//				if(!attach.isEmpty()){
//					if(i==0){
//						errorinfo = "uploadFileError";
//					}else if(i==1){
//						errorinfo = "uploadOcError";
//					}
//					//获取上传文件的原文件名
//					String oldPathName = attach.getOriginalFilename();
//					//获取上传文件的后缀名
//					String prefix = FilenameUtils.getExtension(oldPathName);
//					//先判断文件大小
//					if(attach.getSize()>filesize){ //如果上传文件的大小大于设置的最大字节
//						request.setAttribute(errorinfo,"上传文件过大！");
//						flag=false;
//					}else if(prefix.equalsIgnoreCase("jpg")
//							||prefix.equalsIgnoreCase("png")
//							||prefix.equalsIgnoreCase("jpeg")
//							||prefix.equalsIgnoreCase("pneg")){
//						//如果上传文件满足各条件
//						//设置新的文件名
//						String fileName = System.currentTimeMillis()+RandomUtils.nextInt(10000000)+"_Personal.jpg";
//						//指定文件夹存放上传的图片
//						File targetFile = new File(path,fileName);
//						//如果该文件夹不存在，就重新创建一个
//						if(!targetFile.exists()){
//							targetFile.mkdirs();
//						}
//						//把上传文件保存到新建的文件夹中
//						try {
//							attach.transferTo(targetFile);
//						} catch (Exception e) {
//							request.setAttribute(errorinfo,"上传失败！");
//							flag = false;
//						}
//						//如果保存成功  就把该文件的绝对路径获取出来
//						if(i==0){
//							companyLicPicPath = path+File.separator+fileName;
//						}else if(i==1){
//							orgCodePicPath =  path+File.separator+fileName;
//						}
//
//					}else{ //如果上传文件的后缀不等于指定的这几个
//						request.setAttribute(errorinfo,"上传文件类型不正确！");
//						flag= false;
//					}
//				}

//			}
//		}
//		if(flag){
//			//登陆人的id
//			long   loginerid   = ((User)(session.getAttribute(Constants.SESSION))).getId();
//			provider.setModifyBy(loginerid);
//			//创建时间
//			provider.setModifyDate( new  Date());
//			//营业执照
//			provider.setCompanyLicPicPath(companyLicPicPath);
//			//组织机构代码证
//			provider.setOrgCodePicPath(orgCodePicPath);
//
//			if(providerservice.updateProviderbyid(provider)==1){
//				return "redirect:/provider/providerlist.html";
//			}
//		}
		return "provideradd";
	}




//	//删除图片
//	public void deleteFile(String path) {
//		File file = new File(path);
//		if (!file.isDirectory()) {  //如果path是一个具体的文件绝对路径
//			file.delete();
//		} else if (file.isDirectory()) { //如果path是一个文件夹
//			String[] filelist = file.list(); //查找该文件夹下的文件或文件夹数组
//			for (int i = 0; i < filelist.length; i++) { //循环遍历该数组
//				File filessFile = new File(path + "\\" + filelist[i]);
//				if (!filessFile.isDirectory()) {
//					filessFile.delete();
//				} else if (filessFile.isDirectory()) {
//					deleteFile(path + "//" + filelist[i]);
//				}
//			}
//			file.delete();
//		}
//	}
	//根据id删除供应商
	@RequestMapping("/deleteprovider/{id}")
	@ResponseBody
	public Object deleteprovider(@PathVariable String id){
		HashMap<String,Object> m = new HashMap<String,Object>();
		//查询出该供应商下的订单集合
		List<Bill> billlist=billservice.getbillbypproviderid(id);	
		//根据供应商id查找供应商
		Provider provider = providerservice.getProviderbyid(id);
		if(id==null||id==""){
			m.put("delResult", "notexist");
		}else{
//			if(billlist.size()>0){//先根据id查询该供应商下面是否有订单， 如果有则不能执行删除，否则执行删除操作
//				m.put("delResult",billlist.size());
//			}else{
//				try {
//					//执行删除操作
//					int count=  providerservice.deleteproviderbyid(id);
//					if(count>0){
//						deleteFile(provider.getCompanyLicPicPath());
//						deleteFile(provider.getOrgCodePicPath());
//						m.put("delResult", "true");
//					}else{
//						m.put("delResult", "false");
//					}
//				} catch (Exception e) {
//					e.getStackTrace();
//					m.put("delResult", "false");
//				}
//
//			}
		}

		return JSONArray.toJSONString(m);
	}
}
