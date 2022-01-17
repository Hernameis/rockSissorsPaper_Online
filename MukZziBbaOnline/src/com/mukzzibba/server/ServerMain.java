package com.mukzzibba.server;

import com.mukzzibba.server.socketNetwork.ChatWriter;

public class ServerMain {
	
	public static void main(String[] args) {
		Thread cw=new ChatWriter();
		cw.start();
		new WaitingForClient();
	}
}
