package com.lrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lrd.entity.AppInfo;
import com.lrd.entity.AppVersion;
import com.lrd.entity.page.PageInfo;
import com.lrd.service.AppCategoryService;
import com.lrd.service.AppInfoService;
import com.lrd.service.AppVersionService;
import com.lrd.service.DataDictionaryService;

@Controller
public class ManagerAppInfoController {

	@Autowired
	private AppInfoService ais;
	@Autowired
	private DataDictionaryService dds;
	@Autowired
	private AppCategoryService acs;
	@Autowired
	private AppVersionService avs;
	
	@RequestMapping(value="/manager/backend/app/list",method={RequestMethod.GET,RequestMethod.POST})
	public String getAppInfo(Integer pageIndex,AppInfo app,Model model,HttpSession session){
		pageIndex = pageIndex == null ? 1 : pageIndex;
		Integer pageSize=5;
		app.setStatus(1);//待审核
		PageInfo<AppInfo> appInfoList=ais.findAppInfo(pageIndex, pageSize, app);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("app",app);
		model.addAttribute("flatFormList",dds.getdataDictionaries("所属平台"));
		model.addAttribute("categoryLevel1List",acs.getCategoryList(0));
		if (app!=null &&app.getCategoryLevel1()!=null) {
			model.addAttribute("categoryLevel2List",acs.getCategoryList(app.getCategoryLevel1()));
			if (app.getCategoryLevel2()!=null) {
				model.addAttribute("categoryLevel3List",acs.getCategoryList(app.getCategoryLevel2()));
			}
		}
		return "jsp/backend/applist";
	}
	
	@RequestMapping(value="/manager/backend/app/check",method={RequestMethod.GET})
	public String check(Integer aid,Integer vid,Model model){
		model.addAttribute("appInfo", ais.getAppInfo(new AppInfo(aid, vid)));
		model.addAttribute("appVersion",avs.getAppVersion(new AppVersion(vid)));
		return "jsp/backend/appcheck";
	}
	
	@RequestMapping(value="/manager/backend/app/checksave",method={RequestMethod.POST})
	public String checksave(AppInfo app){
		if (null != app) {
			if (ais.updateAppInfo(app)) {
				return "redirect:/manager/backend/app/list";
			}
		}
		return "jsp/backend/appcheck";
	}
	
}
