package com.buy.tsg.handlerexception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerException implements HandlerExceptionResolver  {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
        String message = null;
        if(ex instanceof MyException) {
            message = ((MyException) ex).getMessage();
        }
        
        else {
            message = "test.....";
        }
        
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", message);
        modelAndView.setViewName("error");
        
        return modelAndView;
	}

}
