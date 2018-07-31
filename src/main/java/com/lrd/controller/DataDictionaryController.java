package com.lrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lrd.service.DataDictionaryService;

@Controller
public class DataDictionaryController {

	@Autowired
	private DataDictionaryService dds;
	
	@RequestMapping(value="/dev/flatform/app/datadictionarylist.json",method={RequestMethod.GET})
	@ResponseBody
	public String getDatadictionarylist(){
		return JSON.toJSONString(dds.getdataDictionaries("所属平台"));
	}
	
}
