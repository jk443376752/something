package com.buy.tsg.service.impl;

import javax.jws.WebService;

import com.buy.tsg.service.SendService;


@WebService(endpointInterface="com.buy.tsg.service.SendService")
public class SendServiceImpl implements SendService {

	@Override
	public boolean sendOA(String param) {
		System.out.println("-------sendOA---------param:"+param);
		
		if(param.equals("jiangk")){
			return true;
		}
		return false;
	}
	

}
