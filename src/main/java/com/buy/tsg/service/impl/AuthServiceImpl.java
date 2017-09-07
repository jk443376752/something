package com.buy.tsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.mapper.AuthMapper;
import com.buy.tsg.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private  AuthMapper authMapper;;

	@Override
	public List<String> selectAuthByUsername(String username) {
		// TODO Auto-generated method stub
		return authMapper.selectAuthByUsername(username);
	}

	@Override
	public List<String> selectAuthByRoleNames(List<String> roleNames) {
		// TODO Auto-generated method stub
		return authMapper.selectAuthByRoleNames(roleNames);
	}

}
