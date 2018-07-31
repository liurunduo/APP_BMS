package com.lrd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lrd.service.AppCategoryService;

@Controller
public class AppCategoryController {
	
	@Autowired
	private AppCategoryService acs;
	
	@RequestMapping(value="/dev/flatform/app/categorylevellist.json",method={RequestMethod.GET})
	@ResponseBody
	private String getDevAppCategoryList(Integer pid){
	 	return getAppCategoryList(pid);
	}
	
	@RequestMapping(value="/manager/backend/app/categorylevellist.json",method={RequestMethod.GET})
	@ResponseBody
	private String getManagerAppCategoryList(Integer pid){
	 	return getAppCategoryList(pid);
	}
	
	private String getAppCategoryList(Integer pid){
		pid=null==pid?0:pid;
		return JSON.toJSONString(acs.getCategoryList(pid));
	}
}
