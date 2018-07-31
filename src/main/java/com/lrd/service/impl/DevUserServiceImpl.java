package com.lrd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrd.dao.DevUserDao;
import com.lrd.entity.DevUser;
import com.lrd.service.DevUserService;

@Service
public class DevUserServiceImpl implements DevUserService{

	@Autowired
	private DevUserDao dud;
	
	@Override
	public DevUser login(DevUser user) {
		// TODO Auto-generated method stub
		return dud.getUser(user);
	}

	
}
