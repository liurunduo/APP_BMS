package com.lrd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrd.dao.BackendUserDao;
import com.lrd.entity.BackendUser;
import com.lrd.service.BackendUserService;
@Service
public class BackendUserServiceImpl implements BackendUserService{

	@Autowired
	private BackendUserDao bud;
	
	@Override
	public BackendUser login(BackendUser user) {
		// TODO Auto-generated method stub
		return bud.getUser(user);
	}

}
