package com.lrd.service;

import java.util.List;

import com.lrd.entity.DataDictionary;

public interface DataDictionaryService {
	
	List<DataDictionary> getdataDictionaries(String typeName);
}
