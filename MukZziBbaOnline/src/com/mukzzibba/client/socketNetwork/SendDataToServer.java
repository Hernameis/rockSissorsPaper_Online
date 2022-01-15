package com.mukzzibba.client.socketNetwork;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.ResultData;

public class SendDataToServer {

	public static void registData(){
		ObjectOutputStream oos=null;
		
		try {
			oos=new ObjectOutputStream(UserData.os);
			oos.writeObject(UserData.regist);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loginData(){
		OutputStream os=null;
		ObjectOutputStream oos=null;;
		LoginData user=UserData.login;
		
		try {
			os=UserData.mainSocket.getOutputStream();
			oos=new ObjectOutputStream(os);
			oos.writeObject(user);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void intData(int msg){
		OutputStream os=null;
		
		try {
			os=UserData.mainSocket.getOutputStream();
			
			os.write(msg);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
