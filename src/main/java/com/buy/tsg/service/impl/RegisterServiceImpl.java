package com.buy.tsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.mapper.LoginUserMapper;
import com.buy.tsg.service.RegisterService;
import com.buy.tsg.utils.ResponseInfo;
@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private LoginUserMapper loginUserMapper;
	
	
	@Override
	public ResponseInfo checkRegister(String username, String password, String repassword) {
		ResponseInfo responseInfo = new ResponseInfo();
		
		LoginUser loginUser = loginUserMapper.selectLoginUserByUserName(username);
		
		if(loginUser!=null){
			responseInfo.setIs_abnormal(0);
			responseInfo.setRemark("用户名已存在!");
			return responseInfo;
		}
		
		if(password.equals(username)){
			responseInfo.setIs_abnormal(0);
			responseInfo.setRemark("用户名和密码不能相同!");
			return responseInfo;
		}
		
		if(!password.equals(repassword)){
			responseInfo.setIs_abnormal(0);
			responseInfo.setRemark("两次输入的密码不一致!");
			return responseInfo;
		}
		
		responseInfo.setIs_abnormal(1);
		responseInfo.setRemark("注册成功!");
		return responseInfo;
		
	}

	@Override
	public void insertRegisterUser(LoginUser loginUserParameter) {
		loginUserMapper.insertRegisterUser(loginUserParameter);
		
	}

}
