package com.buy.tsg.service.impl;

import com.buy.tsg.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public String sayHello(String name) {
		return "Hello:1dubbo2!!!"+name+"";  
	}

}
