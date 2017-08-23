package com.buy.tsg.service;

import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface SendService {
	
	public boolean sendOA(@WebParam(name="param") String param);

}
