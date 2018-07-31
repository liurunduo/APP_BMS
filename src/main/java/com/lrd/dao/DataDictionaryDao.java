package com.lrd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrd.entity.DataDictionary;

public interface DataDictionaryDao {
	List<DataDictionary> getDataDictionaries(@Param("typeName")String typeName);
}
