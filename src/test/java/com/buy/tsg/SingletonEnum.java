package com.buy.tsg;

public enum SingletonEnum {
	
	instance;
	
	public SingletonEnum getInstance() {
        return instance;
	}

}
