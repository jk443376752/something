package com.buy.tsg.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.service.common.RedisServiceImpl;
import com.buy.tsg.utils.HttpSessionUtil;

/**
 * 
 * @author Administrator
 * 已经用shiro做登录拦截 ,不用springmvc拦截器的方式了
 *
 */
public class LoginInterceptor implements  HandlerInterceptor{
	@Autowired
	private RedisServiceImpl redisServiceImpl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
        String url = request.getRequestURL().toString();
        
        if(url.indexOf("login")>=0){ 
        	   return true; 
        }
        
        if(url.indexOf("resources")>=0){ 
     	   return true; 
        }
        
		LoginUser loginUser = redisServiceImpl.get("loginUser",LoginUser.class);
		
		if(loginUser!=null){
			HttpSessionUtil.getRequest().setAttribute("username", loginUser.getUsername());
			return true; 
		}
		
		request.getRequestDispatcher("/login.jsp").forward(request, response); 
	    
		return false; 
        
        
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
