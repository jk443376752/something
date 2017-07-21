package com.buy.tsg.service;


import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.utils.ResponseInfo;

public interface UserLoginService {
	
	LoginUser getUser(Integer id);

	ResponseInfo checkLogin(LoginUser user );
	
	void LoginOut();
	
}
