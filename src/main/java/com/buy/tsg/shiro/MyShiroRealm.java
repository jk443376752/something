package com.buy.tsg.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.service.UserLoginService;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserLoginService userLoginService;
	
	/**
	 * 获取权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		
		String currentUsername = (String)super.getAvailablePrincipal(pc); 
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo(); 
		simpleAuthorInfo.addRole("root");  
        //添加权限  
        simpleAuthorInfo.addStringPermission("root:find");  
        return simpleAuthorInfo;  
	}

    /*** 
     * 获取认证信息 
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
		 UsernamePasswordToken token = (UsernamePasswordToken) at; 
        // 通过表单接收的用户名  
        String username = token.getUsername(); 
        
        if (username != null && !"".equals(username)) {  
            LoginUser user = userLoginService.selectLoginUserByUserName(username);  
            if (user != null) {  
                return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());  
            }  
        }  
        
        return null;  
	}

}
