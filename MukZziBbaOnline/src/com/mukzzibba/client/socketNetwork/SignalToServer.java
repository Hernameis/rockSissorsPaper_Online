package com.mukzzibba.client.socketNetwork;

import java.io.IOException;

import com.mukzzibba.server.data.ResultData;
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
				UserData.result=res;
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
				System.out.println("입력이 잘못됨");
			}
		
		if(!msg.equals("chat")){
			StreamCloser.closeInStream();
			StreamCloser.closeOutStream();
			SocketController.CloseSocket();			
		}
	}
	
	
}
