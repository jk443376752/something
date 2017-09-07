package com.buy.tsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.mapper.RoleMapper;
import com.buy.tsg.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper; 
	
	@Override
	public List<String> selectRoleByUsername(String currentUsername) {
		// TODO Auto-generated method stub
		return roleMapper.selectRoleByUsername(currentUsername);
	}

}
