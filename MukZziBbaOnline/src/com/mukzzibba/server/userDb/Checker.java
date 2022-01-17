package com.mukzzibba.server.userDb;

import java.net.Socket;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.RegistData;
import com.mukzzibba.server.socketNetwork.ReceiveDataFromClient;
import com.mukzzibba.server.socketNetwork.SendDataToClient;

public class Checker {
	
	public static void acceptLogin(Socket sock){
		LoginData user=null;
		user=ReceiveDataFromClient.loginData(sock);
		String name=user.nickname.getText();
		String pass=user.password.getText();
		if(NicknameDB.isNameInDb(name)) {
			if(isPasswordMatchNickname(name,pass)){
				System.out.println("���̵� ��� ��ġ");
				SendDataToClient.intData(sock, 0);
				SendDataToClient.userInfoData(sock,name);
				return ;
			} else {
				System.out.println("��� �z��");
				SendDataToClient.intData(sock, 1);
			}
		} else {
			System.out.println("�� ����");
			SendDataToClient.intData(sock, 2);
		}
	}
	
	public static void checkNickname(Socket sock){
		RegistData user=null;
		String name=null;
		
		user=Register.getRegistID(sock);
		name=user.nickname.getText();
		if(NicknameDB.isNameInDb(name)) {
			Register.sendMsgToClient("��� �Ұ���", sock);
		} else {
			Register.sendMsgToClient("��� �����մϴ�", sock);
		}
	}
	
	public static boolean isPasswordMatchNickname(String name, String pass) {
		UserInfo user=null;
		user=UserDB.getUserFromFile(name);
		if(!user.password.equals(pass)){
			return false;
		}
		return true;
	}
	
}
