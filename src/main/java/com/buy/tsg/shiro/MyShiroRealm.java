package com.buy.tsg.shiro;

import java.util.List;
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

import com.buy.tsg.entity.Auth;
import com.buy.tsg.entity.LoginUser;
import com.buy.tsg.service.AuthService;
import com.buy.tsg.service.RoleService;
import com.buy.tsg.service.UserLoginService;
import com.buy.tsg.utils.HttpSessionUtil;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private AuthService authService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 获取权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		//获取当前用户的名字
		String currentUsername = (String)super.getAvailablePrincipal(pc); 
		//根据用户名查询具有的角色
		List<String> roleNames = roleService.selectRoleByUsername(currentUsername);
		
		//根据用户名查询具有的权限
		List<String> authNames = authService.selectAuthByUsername(currentUsername);
		
		System.out.println("当前用户为----"+currentUsername);
		System.out.println("为其添加的角色组为----"+roleNames);
		System.out.println("为其添加的权限组为----"+authNames);
		
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo(); 
		//如果角色和权限都为空 ,直接返回一个空对象 . 
		if(roleNames==null&&authNames==null){
	        return null;  
		}
		if(roleNames!=null){
			for (String role : roleNames) {
				//添加角色
				simpleAuthorInfo.addRole(role); 
			}
		}
		//拿到所有角色里面去重的所有权限
		List<String> authRolesAuth= authService.selectAuthByRoleNames(roleNames);
		
		//先把角色里面的权限加进去.
		for (String auth : authRolesAuth) {
			simpleAuthorInfo.addStringPermission(auth);
		}
		
		System.out.println("所有角色里面的去重权限为:------"+authRolesAuth);
		
		for (String auth : authNames) {
	        //添加用户自带的权限  ,判断 ,如果authRolesAuth里面有的就不添加 .
			if(!authRolesAuth.contains(auth)&&auth!=null){
				simpleAuthorInfo.addStringPermission(auth);
			}
		}
		//因为角色也包含权限 ,查询出来 , 如果当前用户已经具有该权限 , 就不用添加了 , 如果没有就添加 . 
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
