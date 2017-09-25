package com.buy.tsg.date;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	
	@Test
	public void testName() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		
		String dstr="2008-4-24";  
		java.util.Date date=sdf.parse(dstr);
		System.out.println(date);
		System.out.println(new Date());
		System.out.println("Wed Sep 20 00:00:00 CST 2017");
	}

}
