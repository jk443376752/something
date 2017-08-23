package com.buy.tsg.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.service.common.RedisServiceImpl;
import com.buy.tsg.utils.HttpSessionUtil;

public class LoginInterceptor implements  HandlerInterceptor{
	@Autowired
	private RedisServiceImpl redisServiceImpl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		LoginUser loginUser = redisServiceImpl.get("loginUser",LoginUser.class);
		
		if(loginUser!=null){
			HttpSessionUtil.getRequest().setAttribute("username", loginUser.getUsername());
		}
		
        String url = request.getRequestURL().toString();
        
        if(url.equals("http://localhost:8080/")||url.equals("http://localhost:8080")||
        		url.equals("http://localhost:8080/login") || url.equals("http://localhost:8080/login.jsp")) {
            return true;
        }else{
        	
            if(loginUser == null) {
                response.sendRedirect("/login.jsp");
                return false;
            }
        	
        }
        return true;
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
