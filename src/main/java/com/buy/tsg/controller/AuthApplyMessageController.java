package com.buy.tsg.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.service.AuthApplyMessageService;
import com.buy.tsg.utils.HttpSessionUtil;
import com.buy.tsg.utils.PageList;
import com.buy.tsg.utils.ResponseInfo;

@Controller
@RequestMapping("/AuthApplyMessage")
public class AuthApplyMessageController {
	private Logger log = LoggerFactory.getLogger(AuthApplyMessageController.class);
	
	@Autowired
	private AuthApplyMessageService authApplyMessageService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public ResponseInfo getAll(@RequestParam("currentPage") String currentPage ,
			AuthApplyMessageQueryParameter authApplyMessageQueryParameter) {
		
		if(currentPage==null||currentPage==""){
			authApplyMessageQueryParameter.setCurrentPage(1);
		}else{
			authApplyMessageQueryParameter.setCurrentPage(Integer.valueOf(currentPage));
		}
		ResponseInfo responseInfo = new ResponseInfo();
		PageList<Map<String,Object>> pageList = authApplyMessageService.getAll(authApplyMessageQueryParameter);
		responseInfo.setPageList(pageList);
		return responseInfo;
	}
	
	//正在申请跳转的jsp页面
	@RequestMapping("/applying")
	public String applying() {
		return "/apply/applying";
	}
	
	//申请成功跳转的jsp页面
	@RequestMapping("/applysuccess")
	public String applysuccess() {
		return "/apply/applysuccess";
	}
	
	//申请失败跳转的jsp
	@RequestMapping("/applydefeated")
	public String applydefeated() {
		return "/apply/applydefeated";
	}

}
