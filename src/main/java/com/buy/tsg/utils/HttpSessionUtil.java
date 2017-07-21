package com.buy.tsg.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 *  用于，获取当前登录的用户
 */
public class HttpSessionUtil {
	
	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public static HttpSession getSession(){
		return HttpSessionUtil.getRequest().getSession();
	}
	
}
