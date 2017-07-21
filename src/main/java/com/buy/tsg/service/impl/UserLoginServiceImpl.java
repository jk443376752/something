package com.buy.tsg.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.mapper.LoginUserMapper;
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
			HttpServletRequest request = HttpSessionUtil.getRequest();
	        String ip = request.getHeader("x-forwarded-for");      
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
                ip = request.getHeader("Proxy-Client-IP");      
            }     

            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
                ip = request.getHeader("WL-Proxy-Client-IP");     
            }     

            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
                ip = request.getRemoteAddr();      
            }   
			System.out.println("ip-----"+ip);
			loginUserNew.setIp(ip);
			loginUserNew.setLogintime(null);
			loginUserMapper.updateLoginUser(loginUserNew);
			redisServiceImpl.set("loginUser", loginUser);
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
		redisServiceImpl.del("loginUser");
		HttpSessionUtil.getSession().removeAttribute("username");
	}

}
