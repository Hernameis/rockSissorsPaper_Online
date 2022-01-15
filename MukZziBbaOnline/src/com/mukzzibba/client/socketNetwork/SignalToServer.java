package com.mukzzibba.client.socketNetwork;

import java.awt.Dialog;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.mukzzibba.server.ResultData;
import com.mukzzibba.client.data.ClientSetter;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;
import com.mukzzibba.client.window.ErrorDialog;
import com.mukzzibba.client.window.dupLoginDialog;
import com.mukzzibba.util.IsBool;

public class SignalToServer {
	static String string;
	static int num;
	
	public static void sendMsg(String msg) {
		SocketController.OpenSocket();
		StreamOpener.openOutStream();
		StreamOpener.openInStream();
		
			try {
				UserData.os.write(msg.getBytes());
				UserData.os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(msg.equals("logi")){
				SendDataToServer.loginData();
				UserData.userChecked=ReceiveDataFromServer.intData();
				if(UserData.userChecked==0){
					ReceiveDataFromServer.userInfoData();					
				}
			} else if(msg.equals("dupC")) {
				SendDataToServer.registData();
				string=ReceiveDataFromServer.stringData();
				new ErrorDialog(string, ClientFrame.getInstance());
			} else if (msg.equals("regi")) {
				SendDataToServer.registData();
				string=ReceiveDataFromServer.stringData();
				new ErrorDialog(string, ClientFrame.getInstance());
			} else if (msg.equals("rank")) {
				SendDataToServer.loginData();
				ReceiveDataFromServer.rankInfo();
				UserData.me.rank=ReceiveDataFromServer.intData();
			} else if (IsBool.isGame(msg)) {
				SendDataToServer.loginData();
				ResultData res=null;
				res=ReceiveDataFromServer.resultData();
				ClientSetter.setResultData(res);
			} else if (msg.equals("chat")) { 
				SocketController.openChatSocket();
				SendDataToServer.loginData(); 
				num=ReceiveDataFromServer.intData();
				if(num==1){
					new dupLoginDialog();					
				} else {
					ChatManager.enterChatChannel();
				}
			} else {
				System.out.println("�Է��� �߸���");
			}
		
		if(!msg.equals("chat")){
			StreamCloser.closeInStream();
			StreamCloser.closeOutStream();
			SocketController.CloseSocket();			
		}
	}
	
	public static void sendLoginInfo() {
		StreamOpener.openObjectOutputStream();
		try {
			UserData.oos.writeObject(UserData.login);
			UserData.oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StreamCloser.closeObjectOutputStream();
	}
	
	public static void getResultData(){
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(UserData.is);
			UserData.result=(ResultData)UserData.ois.readObject();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public static void setLogin(int isLogin){
		UserData.userChecked=isLogin;
	}
}
