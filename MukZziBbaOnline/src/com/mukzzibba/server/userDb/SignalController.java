package com.mukzzibba.server.userDb;

import java.net.Socket;

import com.mukzzibba.server.game.Calculator;
import com.mukzzibba.server.socketNetwork.ChatManager;
import com.mukzzibba.server.socketNetwork.ChatReader;
import com.mukzzibba.util.IsBool;

public class SignalController {
	
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
		} else if (msg.equals("chat")) {
			ChatManager.userEnter(sock);
		} else {
			System.out.println("wrong input : "+msg);
		}
	}
}
