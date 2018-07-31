package com.lrd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrd.entity.AppCategory;

public interface AppCategoryDao {
	List<AppCategory> getCategoryList(@Param("parentId")Integer parentId);
}
