package com.buy.tsg.service.impl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public ResponseInfo checkRegister(String username, String password, String repassword,String sex) {
		
		ResponseInfo responseInfo = new ResponseInfo();
		
		String regex = "[A-Za-z][0-9A-Za-z]{3,9}";
		//编译正则表达式
		Pattern pattern = Pattern.compile(regex);
		//匹配正则
		Matcher matcher = pattern.matcher(username);
		
		if(!matcher.matches()){
			responseInfo.setIs_abnormal(0);
			responseInfo.setRemark("用户名必须以字母开头 ,且不存在特殊符号的4到10位字符!");
			return responseInfo;
		}
		
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
		
		if(password.length()>18||repassword.length()>18){
			responseInfo.setIs_abnormal(0);
			responseInfo.setRemark("密码最多不超过18位!");
			return responseInfo;
		}
		
		if(!password.equals(repassword)){
			responseInfo.setIs_abnormal(0);
			responseInfo.setRemark("两次输入的密码不一致!");
			return responseInfo;
		}
		
		LoginUser loginUserParameter = new LoginUser();
		loginUserParameter.setUsername(username);
		loginUserParameter.setPassword(repassword);
		loginUserParameter.setSex(sex);
		loginUserParameter.setCreatetime(new Date());
		loginUserMapper.insertRegisterUser(loginUserParameter);
		
		responseInfo.setIs_abnormal(1);
		responseInfo.setRemark("注册成功!");
		return responseInfo;
		
	}

}
