package com.buy.tsg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.buy.tsg.service.SendService;

public class WebServiceTest {
	
    public static void main(String[] args) {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-webserviceClient.xml");  
        SendService client = (SendService) ctx.getBean("client");  
        boolean flag = client.sendOA("jiangk");  
        System.out.println(flag);  
    }  

}
