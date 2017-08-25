package com.buy.tsg.service;

import javax.jws.WebParam;
import javax.jws.WebService;
@WebService(targetNamespace ="/service.jws/")
public interface SendService {
	
	public boolean sendOA(@WebParam(name="param") String param);

}
