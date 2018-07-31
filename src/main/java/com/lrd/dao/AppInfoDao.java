package com.lrd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrd.entity.AppInfo;

public interface AppInfoDao {
	
	List<AppInfo> findAppInfo(@Param("pageIndex")Integer pageIndex,
			@Param("pageSize")Integer pageSize,@Param("app")AppInfo app);
	AppInfo getAppInfo(AppInfo app);
	int apkexist(@Param("apkname")String apkname);
	int getAppInfoCount(@Param("app")AppInfo app);
	int add(AppInfo app);
	int delete(Integer id);
	int update(AppInfo app);
}
