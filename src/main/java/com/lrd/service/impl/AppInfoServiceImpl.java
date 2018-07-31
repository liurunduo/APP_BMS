package com.lrd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrd.dao.AppInfoDao;
import com.lrd.dao.AppVersionDao;
import com.lrd.entity.AppInfo;
import com.lrd.entity.page.PageInfo;
import com.lrd.service.AppInfoService;

@Service
public class AppInfoServiceImpl implements AppInfoService{

	@Autowired
	private AppInfoDao aid;
	@Autowired
	private AppVersionDao avd;
	@Override
	public PageInfo<AppInfo> findAppInfo(Integer pageIndex, Integer pageSize, AppInfo app) {
		PageInfo<AppInfo> pageInfo =new PageInfo<AppInfo>();
		try {
			Integer totalCount=aid.getAppInfoCount(app);
			pageInfo.setTotalCount(totalCount);
			if( totalCount != null && totalCount != 0 ){
				pageInfo.setPageSize(pageSize);
				pageInfo.setPageIndex(pageIndex);
				pageInfo.setList(aid.findAppInfo((pageInfo.getPageIndex()-1)*pageInfo.getPageSize(),
						pageInfo.getPageSize(), app));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	@Override
	public Boolean addAppInfo(AppInfo app) {
		// TODO Auto-generated method stub
		return aid.add(app)>0;
	}

	@Override
	public Boolean deleteAppInfo(Integer id) {
		// TODO Auto-generated method stub
		avd.deleteVersionByAppId(id);
		return aid.delete(id)>0;
	}

	@Override
	public Boolean updateAppInfo(AppInfo app) {
		// TODO Auto-generated method stub
		return aid.update(app)>0;
	}

	@Override
	public Boolean apkexist(String apkName) {
		// TODO Auto-generated method stub
		return aid.apkexist(apkName)==0;
	}

	@Override
	public AppInfo getAppInfo(AppInfo app) {
		// TODO Auto-generated method stub
		return aid.getAppInfo(app);
	}

}
