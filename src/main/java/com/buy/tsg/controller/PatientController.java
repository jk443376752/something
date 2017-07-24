package com.buy.tsg.controller;

import java.util.Map;

import org.jboss.netty.handler.codec.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buy.tsg.query.PatientQueryParameter;
import com.buy.tsg.service.PatientService;
import com.buy.tsg.utils.PageList;
import com.buy.tsg.utils.ResponseInfo;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	
	@RequestMapping("/getPatientTableList")
	@ResponseBody
	public ResponseInfo getPatientTableList(@RequestParam("currentPage") String currentPage ,
			PatientQueryParameter patientQueryParameter){
		if(currentPage!=null){
			patientQueryParameter.setCurrentPage(Integer.valueOf(currentPage));
		}else{
			patientQueryParameter.setCurrentPage(1);
		}
		ResponseInfo responseInfo = new ResponseInfo();
		PageList<Map<String,Object>> pageList = patientService.getPatientTableList(patientQueryParameter);
		responseInfo.setRemark("获取数据成功");
		responseInfo.setPageList(pageList);
		return responseInfo;
	}
	@RequestMapping("/deleteTableList")
	public ResponseInfo deleteTableList(@RequestParam("pa_id") String paId){
		ResponseInfo responseInfo = new ResponseInfo();
		patientService.deleteTableList(paId);
		return responseInfo;
	}
	
}
