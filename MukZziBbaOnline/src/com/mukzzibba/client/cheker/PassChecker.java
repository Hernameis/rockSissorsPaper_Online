package com.mukzzibba.client.cheker;

import com.mukzzibba.client.data.UserData;

public class PassChecker {
	
	public static boolean passValidation(){
		if(passNumError() || passwordMismatch()){
			return false;
		}
		return true;
	}
	
	public static boolean passNumError(){
		String pass=UserData.regist.password.getText();
		int length=pass.length();
		
		if(length<4 || length>16){
			return true;
		}
		return false;
	}
	
	public static boolean passwordMismatch(){
		String pass=null;
		String passAgain=null;
		
		pass=UserData.regist.password.getText();
		passAgain=UserData.regist.passwordAgain.getText();
		
		if(pass.equals(passAgain)){
			return false;
		}
		return true;
	}
	
}
