package com.buy.tsg.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.buy.tsg.entity.AuthApplyMessage;
import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.mapper.AuthApplyMessageMapper;
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
	@Autowired
	private AuthApplyMessageMapper authApplyMessageMapper;
	
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
	 * 新增用户名验证
	 */
	
	@RequestMapping("/add/checkAddApplying/myModelApplyName")
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
	
	/**
	 * 修改用户名验证
	 * @param username
	 * @return
	 */
	@RequestMapping("/update/myModelApplyName")
	@ResponseBody
	public ResponseInfo updateMyModelApplyName(@RequestParam("username") String username) {
		ResponseInfo rif = new ResponseInfo();
		LoginUser loginUser = null;
		try {
			loginUser = userLoginService.selectLoginUserByUserName(username);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("用户名异常!");
			return rif;
		}
		
		if(loginUser==null){
			rif.setIs_abnormal(0);
			rif.setRemark("该用户名不存在 ,注册后才能为用户添加权限 !");
			return rif;
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
			return rif;
		}

	}
	
	/**
	 * 修改电话验证
	 * @param myModelApplyTelphone
	 * @param applyTelphone
	 * @return
	 */
	@RequestMapping("/update/applyTelphone")
	@ResponseBody
	public ResponseInfo updateMyModelApplyTelphone(@RequestParam("myModelApplyTelphone") String myModelApplyTelphone,
			@RequestParam("applyTelphone") String applyTelphone	
			) {
		ResponseInfo rif = new ResponseInfo();
		
		if(myModelApplyTelphone.equals(applyTelphone)){
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
			return rif;
		}
		//验证手机号码
		String regex = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern pa = Pattern.compile(regex);
		Matcher matcher = pa.matcher(myModelApplyTelphone);
		
		if(!matcher.matches()){
			rif.setIs_abnormal(0);
			rif.setRemark("请输入正确的手机号码 !");
			return rif;
		}
		String appingId = (String)HttpSessionUtil.getSession().getAttribute("applyingId");
		AuthApplyMessage authApplyMessageSession = authApplyMessageMapper.selectByPrimaryKey(Integer.valueOf(appingId));
		AuthApplyMessage applyTelphoneTemp = authApplyMessageMapper.
				selectAuthApplyMessageByApplyTelphone(applyTelphone);
		if(applyTelphoneTemp!=null&&!authApplyMessageSession.getApplyTelphone().equals(applyTelphone)){
			rif.setIs_abnormal(0);
			rif.setRemark("该电话号码已经存在了!");
			return rif;
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
			return rif;
		}
	}
	
	
	/**
	 * 验证申请人电话
	 * @param applyTelphone
	 * @return
	 */
	@RequestMapping("/add/checkAddApplying/applyTelphone")
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
			return rif;
		}
		AuthApplyMessage applyTelphoneTemp = authApplyMessageMapper.selectAuthApplyMessageByApplyTelphone(applyTelphone);
		if(applyTelphoneTemp!=null){
			rif.setIs_abnormal(0);
			rif.setRemark("该电话号码已经存在了!");
			return rif;
		}else{
			rif.setIs_abnormal(1);
			rif.setRemark("验证已通过 !");
			return rif;
		}
	}
	
	/**
	 * 提交新增表单
	 */
	
	@RequestMapping("/add/submitApplyingAdd")
	@ResponseBody
	public ResponseInfo submitApplyingAdd(@RequestBody AuthApplyMessage AuthApplyMessage) {
		ResponseInfo rif = new ResponseInfo();
		if(AuthApplyMessage.getApplyName()==null||AuthApplyMessage.getApplyName()==""||AuthApplyMessage.getApplyTelphone()
			==null||AuthApplyMessage.getApplyTelphone()==""||AuthApplyMessage.getSubmitTime()==null||
			AuthApplyMessage.getBeizhu()==null||AuthApplyMessage.getBeizhu()==""){
				rif.setIs_abnormal(0);
				rif.setRemark("所有选项不能为空 !");
				return rif;
		}
		
		LoginUser loginUser = null;
		try {
			loginUser = userLoginService.selectLoginUserByUserName(AuthApplyMessage.getApplyName());
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("用户名异常!");
			return rif;
		}
		if(loginUser==null){
			rif.setIs_abnormal(0);
			rif.setRemark("该用户名不存在 ,注册后才能为用户添加权限 !");
			return rif;
		}
		
		AuthApplyMessage applyTelphoneTemp = authApplyMessageMapper.selectAuthApplyMessageByApplyTelphone(AuthApplyMessage.getApplyTelphone());
		if(applyTelphoneTemp!=null){
			rif.setIs_abnormal(0);
			rif.setRemark("该电话号码已经存在了!");
			return rif;
		}
		
		Map<String , Object> mapParameetr = new HashMap();
		mapParameetr.put("status",Byte.valueOf("0"));
		mapParameetr.put("applyName", AuthApplyMessage.getApplyName());
		
		AuthApplyMessage authApplyMessageTemp = authApplyMessageMapper.selectAuthApplyMessageByApplyMap(mapParameetr);
		if(authApplyMessageTemp!=null){
			rif.setIs_abnormal(0);
			rif.setRemark("该用户有权限正在申请,请稍后再试 !");
			return rif;
		}
		
		String submitName = (String)HttpSessionUtil.getSession().getAttribute("username");
		List<String> submitTelphone = null;
		try {
			submitTelphone = authApplyMessageService.selectSubmitTelphoneBysubmitName(submitName);
		} catch (Exception e) {
			
		}
		String submitTelphoneStr ="";
		if(submitTelphone!=null){
			submitTelphoneStr = submitTelphone.get(0);
		}
		if(AuthApplyMessage.getApplyName().equals(submitName)){
			rif.setIs_abnormal(0);
			rif.setRemark("申请人和提交人不能是同一人 !");
			return rif;
		}
		
		if(AuthApplyMessage.getApplyTelphone().equals(submitTelphoneStr)){
			rif.setIs_abnormal(0);
			rif.setRemark("申请人和提交人电话不能相同 !");
			return rif;
		}
		try {
			AuthApplyMessage.setSubmitName(submitName);
			AuthApplyMessage.setSubmitTelphone(submitTelphoneStr);
			AuthApplyMessage.setStatus(Byte.valueOf("0"));
			authApplyMessageMapper.insert(AuthApplyMessage);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("添加权限申请异常 !");
			return rif;
		}

		rif.setIs_abnormal(1);
		rif.setRemark("添加权限申请成功 !");
		return rif;
	}
	
	/**
	 * 修改正在申请回显
	 */
	
	@RequestMapping("/updateAuthApplying")
	@ResponseBody
	public ResponseInfo updateAuthApplying(@RequestParam("id") String id) {
		ResponseInfo rif = new ResponseInfo();
		HttpSessionUtil.getSession().setAttribute("applyingId", id);
		AuthApplyMessage primaryKey = authApplyMessageMapper.selectByPrimaryKey(Integer.valueOf(id));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(primaryKey.getSubmitTime());
		Date date = null;
		try {
			date = sdf.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		primaryKey.setSubmitTime(date);
		rif.setObj(primaryKey);
		return rif;
	}
	
	/**
	 * 提交修改表单
	 */
	@RequestMapping("/update/submitApplying")
	@ResponseBody
	public ResponseInfo updateSubmitApplying(@RequestBody AuthApplyMessage AuthApplyMessage) {
		
		ResponseInfo rif = new ResponseInfo();
		String appingId = (String)HttpSessionUtil.getSession().getAttribute("applyingId");
		if(AuthApplyMessage.getApplyName()==null||AuthApplyMessage.getApplyName()==""||AuthApplyMessage.getApplyTelphone()
			==null||AuthApplyMessage.getApplyTelphone()==""||AuthApplyMessage.getSubmitTime()==null||
			AuthApplyMessage.getBeizhu()==null||AuthApplyMessage.getBeizhu()==""){
				rif.setIs_abnormal(0);
				rif.setRemark("所有选项不能为空 !");
				return rif;
		}
		
		LoginUser loginUser = null;
		try {
			loginUser = userLoginService.selectLoginUserByUserName(AuthApplyMessage.getApplyName());
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("用户名异常!");
			return rif;
		}
		if(loginUser==null){
			rif.setIs_abnormal(0);
			rif.setRemark("该用户名不存在 ,注册后才能为用户修改 !");
			return rif;
		}
		AuthApplyMessage authApplyMessageSession = authApplyMessageMapper.selectByPrimaryKey(Integer.valueOf(appingId));
		AuthApplyMessage applyTelphoneTemp = authApplyMessageMapper.
				selectAuthApplyMessageByApplyTelphone(AuthApplyMessage.getApplyTelphone());
		if(applyTelphoneTemp!=null&&!authApplyMessageSession.getApplyTelphone().equals(AuthApplyMessage.getApplyTelphone())){
			rif.setIs_abnormal(0);
			rif.setRemark("该电话号码已经存在了!");
			return rif;
		}
		
//		Map<String , Object> mapParameetr = new HashMap();
//		mapParameetr.put("status",Byte.valueOf("0"));
//		mapParameetr.put("applyName", AuthApplyMessage.getApplyName());
//		
//		AuthApplyMessage authApplyMessageTemp = authApplyMessageMapper.selectAuthApplyMessageByApplyMap(mapParameetr);
//		if(authApplyMessageTemp!=null){
//			rif.setIs_abnormal(0);
//			rif.setRemark("该用户有权限正在申请,请稍后再试 !");
//			return rif;
//		}
		
		String submitName = (String)HttpSessionUtil.getSession().getAttribute("username");
		List<String> submitTelphone = null;
		try {
			submitTelphone = authApplyMessageService.selectSubmitTelphoneBysubmitName(submitName);
		} catch (Exception e) {
			
		}
		
		String submitTelphoneStr ="";
		if(submitTelphone!=null){
			submitTelphoneStr = submitTelphone.get(0);
		}
		
		if(AuthApplyMessage.getApplyName().equals(submitName)){
			rif.setIs_abnormal(0);
			rif.setRemark("申请人和提交人不能是同一人 !");
			return rif;
		}
		
		if(AuthApplyMessage.getApplyTelphone().equals(submitTelphoneStr)){
			rif.setIs_abnormal(0);
			rif.setRemark("申请人和提交人电话不能相同 !");
			return rif;
		}
		
		
		try {
			AuthApplyMessage.setId(Integer.valueOf(appingId));
			authApplyMessageMapper.updateByPrimaryKeySelective(AuthApplyMessage);
		} catch (Exception e) {
			rif.setIs_abnormal(0);
			rif.setRemark("修改权限申请异常 !");
			return rif;
		}

		rif.setIs_abnormal(1);
		rif.setRemark("修改权限申请成功 !");
		return rif;
	}
	
}
