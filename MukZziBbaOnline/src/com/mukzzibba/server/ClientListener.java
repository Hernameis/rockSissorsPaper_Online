package com.mukzzibba.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;

import com.mukzzibba.server.ResultData;
import com.mukzzibba.server.userDb.UserChecker;
import com.mukzzibba.server.userDb.UserDB;

public class ClientListener extends Thread{
	Socket sock;
	String msg;
	char[] charArr;
	int isNext;
	
	InputStream is;
	InputStreamReader isr;
	ObjectInputStream ois;
	
	OutputStream os;
	OutputStreamWriter osw;
	ObjectOutputStream oos;
	
	public ClientListener(Socket sock) {
		this.sock=sock;
		charArr=new char[4];
		run();
	}
	
	@Override
	public void run() {
		msg="";
		try {
			is=sock.getInputStream();
		} catch (IOException e2) {
			e2.printStackTrace();
		}				
		try {
			while(true){
				int isNext=is.read();
				if (isNext!=-1){
					msg+=(char)isNext;
					break;
				}
			}
			for(int i=0; i<3; i++){
				isNext=is.read();
				msg+=(char)isNext;
			}
			System.out.println("msg "+msg);
			
			if(msg.equals("logi")){
//				ois=new ObjectInputStream(is);
//				UserChecker.CheckUserData(ois);
//				ois.close();
			} if(IsBool.isGame(msg)){
//				oos.writeObject(Calculator.getResult(msg));
//				oos.flush();
			} else if(msg.equals("rank")) {
//				oos.writeObject(UserDB.getRank());
//				oos.flush();
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
