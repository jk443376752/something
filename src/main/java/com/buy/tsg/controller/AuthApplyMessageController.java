package com.buy.tsg.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.service.AuthApplyMessageService;
import com.buy.tsg.service.UserLoginService;
import com.buy.tsg.utils.HttpSessionUtil;
import com.buy.tsg.utils.PageList;
import com.buy.tsg.utils.ResponseInfo;

@Controller
@RequestMapping("/AuthApplyMessage")
public class AuthApplyMessageController {
	private Logger log = LoggerFactory.getLogger(AuthApplyMessageController.class);
	
	@Autowired
	private AuthApplyMessageService authApplyMessageService;
	@Autowired 
	private UserLoginService userLoginService;
	
	@RequestMapping("/goPage")
	@ResponseBody
	public ResponseInfo goPage(AuthApplyMessageQueryParameter authApplyMessageQueryParameter ,
			@RequestParam ("currentPage") String currentPage) {
		
		ResponseInfo rif = new ResponseInfo();
		if(authApplyMessageQueryParameter.getCurrentPage()==null){
			authApplyMessageQueryParameter.setCurrentPage(1);
		}else{
			authApplyMessageQueryParameter.setCurrentPage(Integer.valueOf(authApplyMessageQueryParameter.getCurrentPage()));
		}
		PageList<Map<String, Object>> pageList = authApplyMessageService.getAll(authApplyMessageQueryParameter);
		rif.setPageList(pageList);
//		System.out.println(pageList);
		return rif;
	}
	
	
	@RequestMapping("/sousuo")
	@ResponseBody
	public ResponseInfo sousuo(@RequestBody AuthApplyMessageQueryParameter authApplyMessageQueryParameter) {
		ResponseInfo rif  = new ResponseInfo();
		Date startTime=null;
		Date endTime =null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(authApplyMessageQueryParameter.getStarttime()!=null){
			try {
				startTime =sdf.parse(sdf.format(authApplyMessageQueryParameter.getStarttime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			authApplyMessageQueryParameter.setStarttime(startTime);
		}
		if(authApplyMessageQueryParameter.getEndtime()!=null){
			try {
				endTime = sdf.parse(sdf.format(authApplyMessageQueryParameter.getEndtime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			authApplyMessageQueryParameter.setEndtime(endTime);
		}
		
		if(authApplyMessageQueryParameter.getCurrentPage()==null){
			authApplyMessageQueryParameter.setCurrentPage(1);
		}
		
		PageList<Map<String, Object>> pageList = authApplyMessageService.getAll(authApplyMessageQueryParameter);
		rif.setPageList(pageList);
		return rif;
	}
	
	
	@RequestMapping("/AuthApplyAdd")
	@ResponseBody
	public ResponseInfo AuthApplyAdd(){
		ResponseInfo rif  = new ResponseInfo();
		return rif;
	}
	
	@RequestMapping("/AuthApplyDelete")
	@ResponseBody
	public ResponseInfo AuthApplyDelete(@RequestParam("id") Integer id){
		ResponseInfo rif = authApplyMessageService.deleteById(id);
		return rif;
	}
	
	@RequestMapping("/AuthApplyUpdate")
	@ResponseBody
	public ResponseInfo AuthApplyUpdate(){
		ResponseInfo rif  = new ResponseInfo();
		return rif;
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
	
	/**
	 * 以下是模态框处理
	 */
	
	@RequestMapping("/checkAddApplying/myModelApplyName")
	@ResponseBody
	public ResponseInfo checkAddApplyingMyModelApplyName(@RequestParam("username") String username) {
		ResponseInfo rif = new ResponseInfo();
		LoginUser loginUser = null;
		try {
			loginUser = userLoginService.selectLoginUserByUserName(username);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("用户名异常!");
		}
		
		if(loginUser==null){
			rif.setIs_abnormal(0);
			rif.setRemark("该用户名不存在 ,注册后才能为用户添加权限 !");
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
		}
		return rif;
	}
	
	@RequestMapping("/checkAddApplying/applyTelphone")
	@ResponseBody
	public ResponseInfo checkAddApplyingMyModelApplyTelphone(@RequestParam("applyTelphone") String applyTelphone) {
		ResponseInfo rif = new ResponseInfo();
		//验证手机号码
		String regex = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern pa = Pattern.compile(regex);
		Matcher matcher = pa.matcher(applyTelphone);
		
		if(!matcher.matches()){
			rif.setIs_abnormal(0);
			rif.setRemark("请输入正确的手机号码 !");
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
		}
		return rif;
	}
	
	
	@RequestMapping("/checkAddApplying/myModelSubmitName")
	@ResponseBody
	public ResponseInfo checkAddApplyingMyModelMyModelSubmitName(@RequestParam("myModelSubmitName")
		String myModelSubmitName) {
		ResponseInfo rif = new ResponseInfo();
		LoginUser loginUser = null;
		try {
			loginUser = userLoginService.selectLoginUserByUserName(myModelSubmitName);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("用户名异常 !");
		}
		
		if(loginUser==null){
			rif.setIs_abnormal(0);
			rif.setRemark("该用户名不存在 ,注册后才能为用户添加权限 !");
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
		}
		return rif;
	}
	
	@RequestMapping("/checkAddApplying/myModelSubmitTelphone")
	@ResponseBody
	public ResponseInfo checkAddApplyingMyModelSubmitTelphone(@RequestParam("myModelSubmitTelphone") 
	String myModelSubmitTelphone) {
		ResponseInfo rif = new ResponseInfo();
		//验证手机号码
		String regex = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern pa = Pattern.compile(regex);
		Matcher matcher = pa.matcher(myModelSubmitTelphone);
		
		if(!matcher.matches()){
			rif.setIs_abnormal(0);
			rif.setRemark("请输入正确的手机号码 !");
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
		}
		return rif;
	}
	
}
