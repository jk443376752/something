package com.buy.tsg.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="/webservice2")
public interface WebService2 {
	
	public Boolean getTrueOrFalse2(@WebParam(name="parameter")String parameter); 

}
