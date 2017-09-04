package com.buy.tsg;

public class SingleTonLH {
	
	private SingleTonLH singleTonLH;
	
	private SingleTonLH(){};
	
	public synchronized SingleTonLH getInstance(){
		
		if(singleTonLH==null){
			
			singleTonLH = new SingleTonLH();
		}
		
		return singleTonLH;
	}

}
