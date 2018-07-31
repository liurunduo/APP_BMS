package com.lrd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrd.entity.AppVersion;

public interface AppVersionDao {
	List<AppVersion> getAppVersionList(@Param("appId")Integer appId);
	int add(AppVersion version);
	int update(AppVersion version);
	int deleteVersionByAppId(@Param("appId")Integer appId);
	AppVersion getAppVersion(AppVersion version);
}
