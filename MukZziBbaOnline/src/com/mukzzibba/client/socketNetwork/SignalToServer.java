package com.mukzzibba.client.socketNetwork;

import java.io.IOException;

import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.ResultData;

public class SignalToServer {
	
	public static void sendMsg(String msg) {
		OpenAndCloseSocket.OpenSocket();
		StreamOpener.openOutStream();
		
		try {
			UserData.os.write(msg.getBytes());
			UserData.os.flush();
			
			UserData.os.write("exit".getBytes());
			UserData.os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StreamCloser.closeOutStream();
		OpenAndCloseSocket.CloseSocket();
	}
	
	public static ResultData getResultData(){
		ResultData res=null;
		
		OpenAndCloseSocket.OpenSocket();
		StreamOpener.openInStream();
		StreamOpener.openObjectInputStream();
		
		try {
			res=(ResultData)UserData.ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		StreamCloser.closeObjectInputStream();
		StreamCloser.closeInStream();
		OpenAndCloseSocket.CloseSocket();
		
		return res;
	}
}
