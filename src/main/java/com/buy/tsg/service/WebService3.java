package com.buy.tsg.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="/webservice3.jws")
public interface WebService3 {
	
	public Boolean getTrueOrFalse3(@WebParam(name="parameter")String parameter); 

}
