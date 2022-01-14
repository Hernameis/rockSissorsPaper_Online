package com.mukzzibba.server;

public class ServerMain {
	
	public static void main(String[] args) {
		Thread cw=new ChatWriter();
		cw.start();
		new WaitingForClient();
		//이거 동시에 하면 안됨
	}
}
