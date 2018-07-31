package com.lrd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrd.entity.AppVersion;

public interface AppVersionService {
	List<AppVersion> getAppVersionList(Integer appId);
	Boolean addAppVersion(AppVersion version);
	Boolean updateAppVersion(AppVersion version);
	AppVersion getAppVersion(AppVersion version);
}
