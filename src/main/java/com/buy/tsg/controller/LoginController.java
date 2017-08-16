package com.buy.tsg.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@ResponseBody
	public ModelMap login2(){
		ModelAndView mv = new ModelAndView();
		
		ModelMap mp = new ModelMap();
		mp.put("mapName1", "mapValue1");
		mp.put("mapName2", "mapValue2");
		mp.put("mapName3", "mapValue3");
//		设置跳转视图:setViewName(String viewName) 和 setView(View view)。前者是使用viewname，后者是使用预先构造好的View对象
//		mv.setViewName("redirect:/login2.jsp");
		//将map对象添加到ModelAndView里面 .
		mv.addAllObjects(mp);
//		System.out.println("------"+mv.getModelMap());
		return mv.getModelMap();
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
