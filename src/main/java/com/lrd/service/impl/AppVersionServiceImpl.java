package com.lrd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrd.dao.AppInfoDao;
import com.lrd.dao.AppVersionDao;
import com.lrd.entity.AppInfo;
import com.lrd.entity.AppVersion;
import com.lrd.service.AppVersionService;
@Service
public class AppVersionServiceImpl implements AppVersionService{

	@Autowired
	private AppVersionDao avd;
	@Autowired
	private AppInfoDao aid;
	
	@Override
	public List<AppVersion> getAppVersionList(Integer appId) {
		// TODO Auto-generated method stub
		return avd.getAppVersionList(appId);
	}

	@Override
	public Boolean addAppVersion(AppVersion version) {
		// TODO Auto-generated method stub
		/*if (avd.add(version)>0) {
			AppVersion appVersion=avd.getAppVersion(new AppVersion(version.getAppId(),
					version.getVersionNo(), version.getCreationDate()));
			if(null!=appVersion){
				if (aid.update(new AppInfo(appVersion.getAppId(),appVersion.getId()))>0) {
					return true;
				}
			}
		}*/
		return avd.add(version)>0;
	}

	@Override
	public Boolean updateAppVersion(AppVersion version) {
		// TODO Auto-generated method stub
		return avd.update(version)>0;
	}

	@Override
	public AppVersion getAppVersion(AppVersion version) {
		// TODO Auto-generated method stub
		return avd.getAppVersion(version);
	}

}
