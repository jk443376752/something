package com.buy.tsg.entity;

public class Test {
	
	public static void main(String[] args) {
		
		String text = "我说 ,好心好意,无能为力,聊胜于无 !";
		
		String[]  results  = text.split(",");
		
		for (String forYouSay : results) {
			
			System.out.print(forYouSay.substring(0,1));
			
		}
		
	}

}
