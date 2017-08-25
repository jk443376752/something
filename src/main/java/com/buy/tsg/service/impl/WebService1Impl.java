package com.buy.tsg.service.impl;

import javax.jws.WebService;

import com.buy.tsg.service.WebService1;

@WebService(endpointInterface="com.buy.tsg.service.WebService1")
public class WebService1Impl implements WebService1 {

	@Override
	public Boolean getTrueOrFalse1(String parameter) {
		if(parameter.equals("jiangk")){
			return true;
		}else{
			return false;
		}
	}
	

}
