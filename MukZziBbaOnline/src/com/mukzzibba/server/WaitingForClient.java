package com.mukzzibba.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class WaitingForClient {
	public static ServerSocket serv;
	Socket sock;
	InetAddress addr;
	ClientListener cl;
	
	public WaitingForClient() {
		try {
			serv=new ServerSocket(5000);
			
			while(true) {
				try {
					sock=serv.accept();
					addr=sock.getInetAddress();
					System.out.println(addr.getHostName()+"("+addr.getAddress()+") accepted");
					cl=new ClientListener(sock);
					System.out.println(cl);
					cl.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serv.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
