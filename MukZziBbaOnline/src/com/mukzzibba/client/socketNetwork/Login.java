package com.mukzzibba.client.socketNetwork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.controller.PanelController;
import com.mukzzibba.client.data.UserData;


public class Login{

	public static void login(){
		System.out.println("�α��� ����");
		verification();
		if(UserData.userCheck) {
			PanelController.mainToLobbyPanel();
		} else {
			System.out.println("�α��� ������ �߸��Ǿ����ϴ�");
		}
	}
	
	public static void verification(){
//		OpenAndCloseSocket.OpenSocket();
//		
//		
//		
//		OpenAndCloseSocket.CloseSocket();
	}
}
