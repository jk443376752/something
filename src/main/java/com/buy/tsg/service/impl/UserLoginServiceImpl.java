package com.buy.tsg.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.mapper.LoginUserMapper;
import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.service.AuthApplyMessageService;
import com.buy.tsg.service.UserLoginService;
import com.buy.tsg.service.common.BaseServiceImpl;
import com.buy.tsg.service.common.RedisServiceImpl;
import com.buy.tsg.utils.ResponseInfo;
import com.buy.tsg.utils.HttpSessionUtil;
@Service
public class UserLoginServiceImpl extends BaseServiceImpl implements UserLoginService{

	@Autowired
	private LoginUserMapper loginUserMapper;
	@Autowired
	private RedisServiceImpl redisServiceImpl;
	@Autowired 
	private AuthApplyMessageService authApplyMessageService;
	
	@Override
	public LoginUser getUser(Integer id) {
		
		LoginUser loginUser = loginUserMapper.selectByPrimaryKey(id);
		
		return loginUser;
	}

	@Override
	public ResponseInfo checkLogin(LoginUser user) {
		ResponseInfo responseInfo = new ResponseInfo();
		LoginUser loginUser = loginUserMapper.checkUser(user);
		if(loginUser!=null){
			LoginUser loginUserNew = new LoginUser();
			//更改ip
			loginUserNew.setIp(HttpSessionUtil.getRequest().getRemoteAddr());
			//更改登录时间
			Date date=new Date();
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = sdf.format(date);
			Date newLoginTime =null;
			try {
				newLoginTime = sdf.parse(format);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loginUserNew.setLogintime(newLoginTime);
			
			loginUserNew.setId(loginUser.getId());
			loginUserMapper.updateLoginUser(loginUserNew);
			
			//登录成功后把用户存放到redis里面去
//			redisServiceImpl.set("loginUser", loginUser);
			
			//登录成功把用户放到session里面取
			HttpSessionUtil.getSession().setAttribute("username", loginUser.getUsername());
	        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();  
	        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
	        subject.login(token);
	        //登陆成功后把数据放到session里面
			AuthApplyMessageQueryParameter parameter = new AuthApplyMessageQueryParameter();
			authApplyMessageService.getAll(parameter);
	        
			responseInfo.setRemark("登录成功");
			responseInfo.setIs_abnormal(1);
			return responseInfo;
		}

		responseInfo.setRemark("用户名或密码不正确");
		responseInfo.setIs_abnormal(0);
		return responseInfo;
		
	}

	@Override
	public void LoginOut() {
		//redis现在没用
//		redisServiceImpl.del("loginUser");
		HttpSessionUtil.getSession().invalidate();
	}
	
	
	@Override
//	@Transactional(value="transactionManager", propagation = Propagation.REQUIRED ,rollbackFor=Exception.class)
	public void updateLoginUser() {
		LoginUser loginUser = new LoginUser();
		loginUser.setIp("10086");
		loginUser.setCreatetime(new Date());
		loginUser.setId(8);
		loginUserMapper.updateLoginUser(loginUser);
//		int i = 1/0;
	}

	@Override
	public LoginUser selectLoginUserByUserName(String username) {
		return loginUserMapper.selectLoginUserByUserName(username);
	}



}
