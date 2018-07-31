package com.lrd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrd.dao.DataDictionaryDao;
import com.lrd.entity.DataDictionary;
import com.lrd.service.DataDictionaryService;
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService{

	@Autowired
	private DataDictionaryDao ddd;
	
	@Override
	public List<DataDictionary> getdataDictionaries(String typeName) {
		
		return ddd.getDataDictionaries(typeName);
	}

}
