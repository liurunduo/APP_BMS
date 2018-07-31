package com.lrd.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.lrd.entity.AppInfo;
import com.lrd.entity.AppVersion;
import com.lrd.entity.DevUser;
import com.lrd.service.AppInfoService;
import com.lrd.service.AppVersionService;
import com.lrd.util.FileUtil;

@Controller
public class AppVersionController {

	@Autowired
	private AppVersionService avs;
	@Autowired
	private AppInfoService ais;
	
	@RequestMapping(value="/dev/flatform/app/appversionadd",method={RequestMethod.GET})
	public String toAddVersion(Integer id,HttpServletRequest request){
		request.setAttribute("appId", id);
		request.setAttribute("appVersionList", avs.getAppVersionList(id));
		return "jsp/developer/appversionadd";
	}
	
	@RequestMapping(value="/dev/flatform/app/addversionsave",method={RequestMethod.POST})
	public String addVersion(@RequestParam("a_downloadLink")MultipartFile a_downloadLink,
			AppVersion version,HttpServletRequest request,HttpSession session){
		if (null != version) {
			version.setCreatedBy(((DevUser) session.getAttribute("devUserSession")).getId());
			version.setCreationDate(new Timestamp(System.currentTimeMillis()));
			String contextPath = session.getServletContext().getRealPath("statics/uploadfiles");
			String fileName=FileUtil.fileUpload(a_downloadLink, contextPath);
			version.setDownloadLink(request.getContextPath()+"/statics/uploadfiles/"+fileName);
			version.setApkLocPath(contextPath+File.separator+fileName);
			version.setApkFileName(fileName);
			if (avs.addAppVersion(version)) {
				AppVersion appVersion=avs.getAppVersion(new AppVersion(version.getAppId(),
						version.getVersionNo(), version.getApkFileName()));
				if(null!=appVersion){
					if (ais.updateAppInfo(new AppInfo(appVersion.getAppId(),appVersion.getId()))) {
						return "redirect:/dev/flatform/app/list";
					}
				}
			}
		}
		request.setAttribute("error", "添加版本信息失败！");
		return "jsp/developer/appversionadd";
	}
	
	@RequestMapping(value="/dev/flatform/app/appversionmodify",method={RequestMethod.GET})
	public String toAppVersionModify(Integer vid,Integer aid,HttpServletRequest request){
		request.setAttribute("appVersion", avs.getAppVersion(new AppVersion(vid)));
		request.setAttribute("appVersionList", avs.getAppVersionList(aid));
		return "jsp/developer/appversionmodify";
	}
	
	@RequestMapping(value="/dev/flatform/app/appversionmodifysave",method={RequestMethod.POST})
	public String appVersionModifySave(@PathVariable("attach")MultipartFile attach,
			AppVersion version,HttpSession session,HttpServletRequest request){
		if (null != version) {
			version.setModifyBy(((DevUser) session.getAttribute("devUserSession")).getId());
			version.setModifyDate(new Timestamp(System.currentTimeMillis()));
			if (null != attach) {
				String contextPath = session.getServletContext().getRealPath("statics/uploadfiles");
				String fileName=FileUtil.fileUpload(attach, contextPath);
				version.setDownloadLink(request.getContextPath()+"/statics/uploadfiles/"+fileName);
				version.setApkLocPath(contextPath+File.separator+fileName);
				version.setApkFileName(fileName);
			}
			if(avs.updateAppVersion(version)){
				return "redirect:/dev/flatform/app/list";
			}
		}
		request.setAttribute("fileUploadError", "修改版本信息失败！");
		return "jsp/developer/appversionmodify";
	}
	
	@RequestMapping(value="/dev/flatform/app/delApkfile.json",method={})
	@ResponseBody
	public String delFile(Integer id){
		Map<String, String> map =new HashMap<String, String>();
		AppVersion version=avs.getAppVersion(new AppVersion(id));
		if (null != version && null != version.getApkLocPath()) {
			if (FileUtil.deleteFile(version.getApkLocPath())) {
				map.put("result","success");
				avs.updateAppVersion(new AppVersion(id, "", "", ""));
			}else{
				map.put("result","failed");
			}
		}else{
			map.put("result","param000001");
		}
	
		return JSON.toJSONString(map);
	}
	
}
