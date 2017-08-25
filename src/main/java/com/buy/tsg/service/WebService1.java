package com.buy.tsg.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="/webservice1.jws")
public interface WebService1 {
	
	public Boolean getTrueOrFalse1(@WebParam(name="parameter")String parameter); 

}
