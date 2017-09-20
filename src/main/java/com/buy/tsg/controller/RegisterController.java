package com.buy.tsg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String sex = (String)jsonArrayParameter.getJSONObject(3).get("sex");
		ResponseInfo responseInfoCheck = registerService.checkRegister(username, password, repassword ,sex);
		return responseInfoCheck;
	}
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
}
