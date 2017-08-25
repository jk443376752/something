package com.buy.tsg.service.impl;

import javax.jws.WebService;

import com.buy.tsg.service.WebService2;

@WebService(endpointInterface="com.buy.tsg.service.WebService2")
public class WebService2Impl implements WebService2 {

	@Override
	public Boolean getTrueOrFalse2(String parameter) {
		if(parameter.equals("jiangk")){
			return true;
		}else{
			return false;
		}
	}
	

}
