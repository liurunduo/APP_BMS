package com.lrd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrd.entity.AppCategory;

public interface AppCategoryService {
	
	List<AppCategory> getCategoryList(Integer parentId);
}
