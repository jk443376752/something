package com.buy.tsg;

public class SingleTonEH {
	
	private static SingleTonEH singleTon =null;
	
	static{
		singleTon = new SingleTonEH();
	}
	
	private SingleTonEH(){};
	
	public SingleTonEH getInsTance(){
		
		return singleTon;
	}

}
