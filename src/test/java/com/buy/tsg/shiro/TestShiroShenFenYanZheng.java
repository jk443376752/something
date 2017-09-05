package com.buy.tsg.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class TestShiroShenFenYanZheng {
	
	
	@Test
	public void testHellShenFenYanZheng() {  
		
		 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:shiro/shiro.ini"); 
	    
	    //2、得到SecurityManager实例  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance(); 
	    
	    //并绑定给SecurityUtils 
	    SecurityUtils.setSecurityManager(securityManager);  
	    
	    //3.得到Subject
	    Subject subject = SecurityUtils.getSubject();  
	    
	    //创建用户名/密码身份验证Token（即用户身份/凭证）  
	    UsernamePasswordToken token = new UsernamePasswordToken("wang","123");  
	  
	    try {  
	        //4、登录，即身份验证  
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	    	e.printStackTrace();
	        //5、身份验证失败  
	    }  
	  
	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	  
	    //6、退出  
	    subject.logout();  
	}   
	
}
