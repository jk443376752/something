package com.buy.tsg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.service.UserLoginService;
import com.buy.tsg.utils.ResponseInfo;
@Controller
public class LoginController {
	
	private static Logger log=LoggerFactory.getLogger(LoginController.class);
	 
	@Autowired
	private UserLoginService userLoginService; 
	
	@RequestMapping("/login")
	public String login(){
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/login2")
	public String login2(){
		return "redirect:/login2.jsp";
	}
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/getLoginUser")
	@ResponseBody
	public LoginUser getLoginUser(Integer id){
		
		return userLoginService.getUser(id);
		
		
	}
	
	@RequestMapping(value="/login/check",method={RequestMethod.POST})
	@ResponseBody
	public ResponseInfo checkLogin(@RequestParam("username") String username , @RequestParam("password") String password){
		
		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(username);
		loginUser.setPassword(password);
		ResponseInfo responseInfo = userLoginService.checkLogin(loginUser);
		return responseInfo;
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(){
		userLoginService.LoginOut();
		return "redirect:/login.jsp";
	}

}
