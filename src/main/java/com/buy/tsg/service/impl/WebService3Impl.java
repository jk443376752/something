package com.buy.tsg.service.impl;

import javax.jws.WebService;

import com.buy.tsg.service.WebService3;

@WebService(endpointInterface="com.buy.tsg.service.WebService3")
public class WebService3Impl implements WebService3 {

	@Override
	public Boolean getTrueOrFalse3(String parameter) {
		if(parameter.equals("jiangk")){
			return true;
		}else{
			return false;
		}
	}
	

}
