package com.buy.tsg;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderServiceTest {
	
	public static void main(String[] args) {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(    
                new String[]{"applicationProvider.xml"});    
        context.start();   
        System.out.println("�ṩ�߷�����ע��ɹ�!!");    
        System.out.println("�������ȡ���ṩ�߷���!");    
        try {  
            System.in.read();//�ô˳���һֱ�ܣ���ʾһֱ�ṩ����  
        } catch (IOException e) {         
            e.printStackTrace();  
        }    
    }  

}
