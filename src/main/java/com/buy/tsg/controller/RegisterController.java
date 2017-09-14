package com.buy.tsg.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.service.RegisterService;
import com.buy.tsg.utils.ResponseInfo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/checkRegister")
	@ResponseBody
	public ResponseInfo checkRegister(@RequestBody String arrayParameter){
		JSONArray jsonArrayParameter = JSONArray.fromObject(arrayParameter);
		String username = (String)jsonArrayParameter.getJSONObject(0).get("username");
		String password = (String)jsonArrayParameter.getJSONObject(1).get("password");
		String repassword = (String)jsonArrayParameter.getJSONObject(2).get("repassword");
		ResponseInfo responseInfoCheck = registerService.checkRegister(username, password, repassword);
		
		if(responseInfoCheck.getIs_abnormal()==1){
			LoginUser loginUserParameter = new LoginUser();
			loginUserParameter.setUsername(username);
			loginUserParameter.setPassword(repassword);
			loginUserParameter.setCreatetime(new Date());
			registerService.insertRegisterUser(loginUserParameter);
		}
		return responseInfoCheck;
	}
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
}
