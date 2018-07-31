package com.lrd.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.lrd.controller.base.BaseController;
import com.lrd.entity.AppCategory;
import com.lrd.entity.AppInfo;
import com.lrd.entity.AppVersion;
import com.lrd.entity.DevUser;
import com.lrd.entity.page.PageInfo;
import com.lrd.service.AppCategoryService;
import com.lrd.service.AppInfoService;
import com.lrd.service.AppVersionService;
import com.lrd.service.DataDictionaryService;
import com.lrd.util.FileUtil;

@Controller
public class AppInfoController extends BaseController{

	@Autowired
	private AppInfoService ais;
	@Autowired
	private DataDictionaryService dds;
	@Autowired
	private AppCategoryService acs;
	@Autowired
	private AppVersionService avs;
	
	@RequestMapping(value="/dev/flatform/app/list",method={RequestMethod.GET,RequestMethod.POST})
	public String list(Integer pageIndex,AppInfo app,Model model,HttpSession session){
		pageIndex = pageIndex == null ? 1 : pageIndex;
		Integer pageSize=5;
		app.setDevId(((DevUser)session.getAttribute("devUserSession")).getId());
		PageInfo<AppInfo> appInfoList=ais.findAppInfo(pageIndex, pageSize, app);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("app",app);
		model.addAttribute("statusList",dds.getdataDictionaries("APP状态"));
		model.addAttribute("flatFormList",dds.getdataDictionaries("所属平台"));
		model.addAttribute("categoryLevel1List",acs.getCategoryList(0));
		if (app!=null &&app.getCategoryLevel1()!=null) {
			model.addAttribute("categoryLevel2List",acs.getCategoryList(app.getCategoryLevel1()));
			if (app.getCategoryLevel2()!=null) {
				model.addAttribute("categoryLevel3List",acs.getCategoryList(app.getCategoryLevel2()));
			}
		}
		return "jsp/developer/appinfolist";
	}
	
	@RequestMapping(value="/dev/flatform/app/appinfoadd",method={RequestMethod.GET})
	public String toAdd(Model model){
		return "jsp/developer/appinfoadd";
	}
	
	@RequestMapping(value="/dev/flatform/app/apkexist.json",method={RequestMethod.GET})
	@ResponseBody
	public String apkexist(String apkName,HttpSession session){
		Map<String, String> map=new HashMap<String, String>();
		if (null==apkName) {
			map.put("APKName", "empty");
		}else if(ais.apkexist(apkName)){
			map.put("APKName", "noexist");
		}else{
			map.put("APKName", "exist");
		}
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/dev/flatform/app/appinfoaddsave",method={RequestMethod.POST})
	public String addAppInfo(@RequestParam("a_logoPicPath")MultipartFile a_logoPicPath,
		 AppInfo app,HttpSession session,HttpServletRequest request){
		if (null != app) {
			DevUser user=(DevUser) session.getAttribute("devUserSession");
			app.setDevId(user.getId());
			app.setCreatedBy(user.getId());
			app.setCreationDate(new Timestamp(System.currentTimeMillis()));
			String contextPath = session.getServletContext().getRealPath("statics/uploadfiles");
			String fileName=FileUtil.fileUpload(a_logoPicPath, contextPath);
			app.setLogoPicPath(request.getContextPath()+"/statics/uploadfiles/"+fileName);
			app.setLogoLocPath(contextPath+File.separator+fileName);
			if (ais.addAppInfo(app)) {
				return "redirect:/dev/flatform/app/list";
			}
		}
		request.setAttribute("error", "添加APP信息失败！");
		return "jsp/developer/appinfoadd";
	}
	
	@RequestMapping(value="/dev/flatform/app/appview/{id}",method={RequestMethod.GET})
	public String appview(@PathVariable("id")Integer id,
			HttpSession session,HttpServletRequest request){
		request.setAttribute("appInfo", ais.getAppInfo(new AppInfo(null,
				((DevUser) session.getAttribute("devUserSession")).getId(), id)));
		request.setAttribute("appVersionList",avs.getAppVersionList(id));
		return "jsp/developer/appinfoview";
	}
	
	@RequestMapping(value="/dev/flatform/app/delapp.json",method={RequestMethod.GET})
	@ResponseBody
	public String deleteAppInfo(Integer id,HttpSession session){
		Map<String, String> map=new HashMap<String, String>();
		if(null ==id || null==ais.getAppInfo(new AppInfo(null,
				((DevUser) session.getAttribute("devUserSession")).getId(), id))){
			map.put("delResult", "notexist");
		}else if(ais.deleteAppInfo(id)){
			map.put("delResult","true");
		}else{
			map.put("delResult","false");
		}
		
		return JSON.toJSONString(map);
		
	}
	
	@RequestMapping(value="/dev/flatform/app/{id}/sale.json",method={RequestMethod.PUT})
	@ResponseBody
	public String saleAppInfo(@PathVariable("id")Integer id,HttpSession session){
		Map<String, String> map=new HashMap<String, String>();
		if (null!=id) {
			AppInfo app=ais.getAppInfo(new AppInfo(null,
					((DevUser) session.getAttribute("devUserSession")).getId(), id));
			//status等于4为原上架，如果是5为原下架,
			if (null != app) {
				map.put("errorCode", "0");
				AppInfo updApp=new AppInfo();
				updApp.setId(app.getId());
				updApp.setStatus(app.getStatus()==4?5:4);
				updApp.setOnSaleDate(app.getStatus()==4?null:new Timestamp(System.currentTimeMillis()));
				updApp.setOffSaleDate(app.getStatus()==4?new Timestamp(System.currentTimeMillis()):null);
				if (app.getStatus()==4) {
					//版本改为不发布
					avs.updateAppVersion(new AppVersion(app.getVersionId(), 1));
				}else{	//版本改为发布
					avs.updateAppVersion(new AppVersion(app.getVersionId(), 2));
				}
				if(ais.updateAppInfo(updApp)){
					map.put("resultMsg","success");
				}else{
					map.put("resultMsg", "failed");
				}
			}else{
				map.put("errorCode", "exception000001");
			}
		}else{
			map.put("errorCode", "param000001");
		}
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/dev/flatform/app/appinfomodify",method={RequestMethod.GET})
	public String toAppinfomodify(Integer id,Model model,HttpSession session){
		if (null!=id) {
			AppInfo app=ais.getAppInfo(new AppInfo(null,
					((DevUser) session.getAttribute("devUserSession")).getId(), id));
			if (null != app) {
				model.addAttribute("appInfo", app);
			}
		}
		return "jsp/developer/appinfomodify";
	}
	
	@RequestMapping(value="/dev/flatform/app/delfile.json",method={RequestMethod.GET})
	@ResponseBody
	public String delFile(Integer id,HttpSession session){
		Map<String, String> map =new HashMap<String, String>();
			AppInfo app=ais.getAppInfo(new AppInfo(null,
					((DevUser) session.getAttribute("devUserSession")).getId(), id));
			if (null != app && null != app.getLogoLocPath()) {
				if (FileUtil.deleteFile(app.getLogoLocPath())) {
					map.put("result","success");
					ais.updateAppInfo(new AppInfo("", "",app.getId()));
				}else{
					map.put("result","failed");
				}
			}else{
				map.put("result","param000001");
			}
		
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/dev/flatform/app/appinfomodifysave",method={})
	public String appInfoModifySave(@RequestParam("attach")MultipartFile attach,
			AppInfo app,HttpSession session,HttpServletRequest request){
		if (null != app) {
			app.setModifyBy(((DevUser) session.getAttribute("devUserSession")).getId());
			app.setModifyDate(new Timestamp(System.currentTimeMillis()));
			if (null != attach) {
				String contextPath = session.getServletContext().getRealPath("statics/uploadfiles");
				String fileName=FileUtil.fileUpload(attach, contextPath);
				app.setLogoPicPath(request.getContextPath()+"/statics/uploadfiles/"+fileName);
				app.setLogoLocPath(contextPath+File.separator+fileName);
			}
			if (ais.updateAppInfo(app)) {
				return "redirect:/dev/flatform/app/list";
			}
		}
		request.setAttribute("error", "修改APP信息失败！");
		return "jsp/developer/appinfomodify";
	}
	
}
