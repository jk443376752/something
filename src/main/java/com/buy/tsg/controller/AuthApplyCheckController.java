package com.buy.tsg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buy.tsg.entity.AuthApplyMessage;
import com.buy.tsg.mapper.AuthApplyMessageMapper;
import com.buy.tsg.service.AuthApplyMessageService;
import com.buy.tsg.utils.ResponseInfo;
@Controller
@RequestMapping("/management")
public class AuthApplyCheckController {
	@Autowired
	private AuthApplyMessageService authApplyMessageService;
	@Autowired
	private AuthApplyMessageMapper authApplyMessageMapper;
	
	@RequestMapping("/authapply")
	public String checkAuthApply(){
		return "management/authapply";
	}
	
	@RequestMapping("/authApplyReturn")
	@ResponseBody
	public ResponseInfo authApplyReturn(@RequestParam("defeatMessage") String defeatMessage,
			@RequestParam("id") Integer id){
		ResponseInfo rif = new ResponseInfo();
		AuthApplyMessage authApplyMessage = authApplyMessageMapper.selectAuthApplyMessageById(id);
		authApplyMessage.setDefeatmessage(defeatMessage);
		authApplyMessage.setStatus(Byte.valueOf("2"));
		try {
//			authApplyMessageService.updateByPrimaryKey(authApplyMessage);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("退回异常 !");
			return rif;
		}
		rif.setIs_abnormal(1);
		rif.setRemark("退回成功 !");
		return rif;
	}
	
	@RequestMapping("/authApplyPass")
	@ResponseBody
	public ResponseInfo authApplyPass(@RequestParam("id") Integer id){
		ResponseInfo rif = new ResponseInfo();
		AuthApplyMessage authApplyMessage = authApplyMessageMapper.selectAuthApplyMessageById(id);
		authApplyMessage.setStatus(Byte.valueOf("1"));
		try {
			authApplyMessageService.updateByPrimaryKey(authApplyMessage);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("审批异常 !");
			return rif;
		}
		rif.setIs_abnormal(1);
		rif.setRemark("审批成功 !");
		return rif;
	}
	

}
