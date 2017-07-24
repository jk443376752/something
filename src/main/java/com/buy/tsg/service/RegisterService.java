package com.buy.tsg.service;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.utils.ResponseInfo;

public interface RegisterService {
	
	ResponseInfo checkRegister(String username ,String password ,String repassword);
	
	void insertRegisterUser(LoginUser loginUserParameter);
}
