package com.buy.tsg.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.buy.tsg.controller.LoginController;
@Service
public class BaseServiceImpl {
	protected static Logger log=LoggerFactory.getLogger(LoginController.class);
}
