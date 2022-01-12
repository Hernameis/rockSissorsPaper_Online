package com.mukzzibba.server.userDb;

import java.io.IOException;
import java.net.Socket;

import com.mukzzibba.server.Calculator;
import com.mukzzibba.util.IsBool;

public class DataController {
	
	public static void SendResultToClient(String msg, Socket sock) {
		if(msg.equals("logi")){
			Checker.acceptLogin(sock);
		} else if(msg.equals("dupC")) {
			Checker.checkNickname(sock);
		} else if (msg.equals("regi")) {
			Register.registerNewID(sock);
		} else if (msg.equals("rank")) {
			RankingBoard.getRank(sock);
		} else if (IsBool.isGame(msg)) {
			Calculator.sendResult(msg, sock);
		} else {
			System.out.println("wrong input : "+msg);
		}
	}
}
