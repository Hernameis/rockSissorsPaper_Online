package com.mukzzibba.server.socketNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatReader extends Thread{
	
	private Socket sock;
	private BufferedReader br;
	private String read;
	private String name;
	
	public ChatReader(Socket sock, String name){
		this.sock=sock;
		this.name=name;
	}
	
	@Override
	public void run() {
		if(sock!=null){
			br=openStream(sock);			
		}
		while(true) {
			try {
				read=br.readLine();
				if(read==null){
					break;
				}
				System.out.println(read);
				ChatWriter.addStrToQueue(name+" : "+read);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ChatWriter.removeUser(name);
		closeStream(sock);
		closeSocket(sock);
		System.out.println("연결이 종료되었습니다");
		
	}
	
	private BufferedReader openStream(Socket sock){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return br;
	}
	
	private void closeStream(Socket sock){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void closeSocket(Socket sock){
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
