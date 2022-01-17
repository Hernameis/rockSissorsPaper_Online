package com.mukzzibba.client.socketNetwork;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.mukzzibba.client.data.UserData;

public class ChatWriter {
	
	public static void sayToAll(String msg){
		Socket sock=null; 
		OutputStream os=null;
		OutputStreamWriter osw=null;
		BufferedWriter bw=null;
		sock=UserData.chatSocket;
		try {
			os=sock.getOutputStream();
			osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
			
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
