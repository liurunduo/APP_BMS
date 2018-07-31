package com.lrd.service;

import com.lrd.entity.AppInfo;
import com.lrd.entity.page.PageInfo;

public interface AppInfoService {
		
	PageInfo<AppInfo> findAppInfo(Integer pageIndex,Integer pageSize,AppInfo app);
	Boolean addAppInfo(AppInfo app);
	Boolean deleteAppInfo(Integer id);
	Boolean updateAppInfo(AppInfo app);
	Boolean apkexist(String apkName);
	AppInfo getAppInfo(AppInfo app);
}
