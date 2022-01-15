package com.mukzzibba.server;

public class ServerMain {
	
	public static void main(String[] args) {
		Thread cw=new ChatWriter();
		cw.start();
		new WaitingForClient();
	}
}
