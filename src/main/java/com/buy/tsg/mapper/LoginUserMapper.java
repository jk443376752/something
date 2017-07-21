package com.buy.tsg.mapper;

import com.buy.tsg.entity.LoginUser;

public interface LoginUserMapper {
	
	void updateLoginUser (LoginUser loginUser);
	
    int deleteByPrimaryKey(Integer id);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);

    LoginUser checkUser(LoginUser user);
}