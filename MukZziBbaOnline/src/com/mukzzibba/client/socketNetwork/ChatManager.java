package com.mukzzibba.client.socketNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.mukzzibba.client.data.UserData;

public class ChatManager {
	
	public static void enterChatChannel(){
		Thread reader=new ChatReader();
		reader.start();
	}
	
	public static void closeChatStream(){
		Socket sock=UserData.chatSocket;
		
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		OutputStream os=null;
		OutputStreamWriter osw=null;
		BufferedWriter bw=null;
		
		try {
			is = sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
			os=sock.getOutputStream();
			osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				isr.close();
				br.close();
				
				os.close();
				osw.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
