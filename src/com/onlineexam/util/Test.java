package com.onlineexam.util;

import java.util.concurrent.ConcurrentHashMap;


public class Test {
	
	private int count;

	 public void  synchronizedincreaseCount(){
		count = count +1;
	}
	
	public int getCount(){
		return count;
	}
	
	
	
}
