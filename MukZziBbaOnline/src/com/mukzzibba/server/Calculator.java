package com.mukzzibba.server;

import java.util.Random;

public class Calculator {
	
	private Calculator() {}
	
	public static ResultData getResult(String msg){
		ResultData res=new ResultData();
		
		res.userInt=getIntFromStr(msg);
		res.userStr=new String(msg);
		res.comInt=getRanNum();
		res.comStr=getStrFromInt(res.comInt);
		res.result=getResult(res.userInt, res.comInt);
		
		return res;
	}
	
	private static int getRanNum(){
		Random ran=new Random();
		
		int comInt=ran.nextInt(3);
		return comInt;
	}
	
	private static int getIntFromStr(String msg){
		int userInt;
		
		if(msg.equals("rock")){
			userInt=0;
		} else if(msg.equals("scis")){
			userInt=1;
		} else {
			userInt=2;
		}
		return userInt;
	}
	
	private static String getStrFromInt(int n){
		if(n==0){
			return new String("rock");
		} else if (n==1){
			return new String("scis");
		} else {
			return new String("pape");
		}
	}
	
	private static String getResult(int user, int com){
		if (user==com){
			return new String("draw");
		} else if (user-com==-2 || user-com==1){
			return new String("win");
		} else {
			return new String("lose");
		}
	}
}