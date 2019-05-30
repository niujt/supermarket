package com.wxthxy.supermarket.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.wxthxy.supermarket.entity.User;
import com.wxthxy.supermarket.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.wxthxy.supermarket.entity.Bill;
import com.wxthxy.supermarket.entity.Provider;
import com.wxthxy.supermarket.service.BillService;
import com.wxthxy.supermarket.service.ProviderService;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Resource
    private ProviderService providerservice;
    @Resource
    private BillService billservice;

    //进入供应商列表页面
    @RequestMapping("/providerlist.html")
    public String showproviderlist() {

        return "list/providerlist";
    }

    @RequestMapping(value = "/json/providerlist", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject showproviderlist(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit,
                                       @RequestParam(value = "proCode",required = false)String proCode,@RequestParam(value = "proName",required = false)String proName) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", providerservice.getCount());
        List<Provider> providers = providerservice.getProviderList((page - 1) * limit, limit,proCode,proName);
        json.put("data", providers);
        return json;
    }

    //进入添加供应商列表
    @RequestMapping("/provideradd.html")
    public String provideradd() {
        return "add/provideradd";
    }

    //进入修改供应商页面
    @RequestMapping("/updateprovider.html/{id}")
    public String providermodify(@PathVariable Integer id, HttpServletRequest request) {
        Provider p = providerservice.getProviderbyid(id);
        request.setAttribute("provider", p);
        return "info/providermodify";
    }

    //根据id删除供应商
    @RequestMapping(value = "/deleteprovider/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteprovider(@PathVariable Integer id) {
        JSONObject json = new JSONObject();
        //查询出该供应商下的订单集合
        List<Bill> billlist = billservice.getbillbypproviderid(id);
        //根据供应商id查找供应商
        Provider provider = providerservice.getProviderbyid(id);
        if (billlist.size() != 0) {
            json.put("message", "供应商" + provider.getProName() + "存在订单,无法删除!!!");
        } else {
            Integer count = providerservice.deleteproviderbyid(id);
            if (count > 0) {
                json.put("message", "删除成功");
            } else {
                json.put("message", "删除失败");
            }
        }
        return json;
    }

    //单击添加保存新的供应商信息
    @RequestMapping(value = "/saveprovideradd.html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saveprovideradd(@RequestBody Provider provider, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        provider.setCreatedBy(loginerid);
        //创建时间
        provider.setCreationDate(new Date());
        if (providerservice.saveprovider(provider) == 1) {
            json.put("message", "添加成功");
        } else {
            json.put("message", "添加失败");
        }
        return json;
    }

    //修改供应商
    @RequestMapping(value = "/saveupdateprovider", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject saveprovidermodify(@RequestBody Provider provider, HttpSession session) {
        JSONObject json = new JSONObject();
        //登陆人的id
        long loginerid = ((User) (session.getAttribute(Constants.SESSION))).getId();
        provider.setModifyBy(loginerid);
        //创建时间
        provider.setModifyDate(new Date());
        if (providerservice.updateProviderbyid(provider) == 1) {
            json.put("message", "修改成功");
        } else {
            json.put("message", "修改失败");
        }
        return json;
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

}
