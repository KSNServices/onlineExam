package com.onlineexam.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.onlineexam.util.RandomPasswardGenerator.Mode;

public class ERPHelper {
	
	public static final BCryptPasswordEncoder bce=new BCryptPasswordEncoder();
	
	public static String getHashPassword(String password) {  
		return bce.encode(password);  
	} 
	
	public static boolean matchPassword(String rawPassword,String encodedPassword){
		return bce.matches(rawPassword, encodedPassword);
	}
	
	public static String generateTemporaryPassward(int tempPassLength, String tempPassType){
		Mode passType=null;
		if(tempPassType.equals(Mode.NUMERIC.toString())){
			passType=Mode.NUMERIC;
		}else if(tempPassType.equals(Mode.ALPHA.toString())){
			passType=Mode.ALPHA;
		}else{
			passType=Mode.ALPHANUMERIC;
		}
		return RandomPasswardGenerator.generateRandomPassward(tempPassLength, passType);
	}

	public static void sendMailToUser(){
		
	}
	
	public static void main(String[] args) {
	
		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}
}
