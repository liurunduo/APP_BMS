package com.lrd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrd.dao.AppCategoryDao;
import com.lrd.entity.AppCategory;
import com.lrd.service.AppCategoryService;

@Service
public class AppCategoryServiceImpl implements AppCategoryService{

	@Autowired
	private AppCategoryDao acd;
	
	@Override
	public List<AppCategory> getCategoryList(Integer parentId) {
		// TODO Auto-generated method stub
		return acd.getCategoryList(parentId);
	}

}
