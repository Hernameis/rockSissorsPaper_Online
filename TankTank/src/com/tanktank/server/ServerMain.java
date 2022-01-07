package com.tanktank.server;

import java.io.*;
import java.net.*;
import java.io.IOException;

public class ServerMain extends Thread{
	Socket sock;
	InputStream is;
	OutputStream os;

	public ServerMain(Socket socket){
		sock=socket;
	}
	
	@Override
	public void run() {
		System.out.println(sock.getInetAddress().getHostAddress()+"Ŭ���̾�Ʈ run��");
	}
	
	public static void main(String[] args) {
		ServerSocket serv=null;
		Socket socket=null;
		try {
			serv=new ServerSocket(5000);
			while(true){
				socket=serv.accept();
				Thread a=new ServerMain(socket);				
				a.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}