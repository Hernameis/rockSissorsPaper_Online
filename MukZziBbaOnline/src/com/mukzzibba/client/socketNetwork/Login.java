package com.mukzzibba.client.socketNetwork;

import com.mukzzibba.client.controller.PanelController;
import com.mukzzibba.client.data.UserData;


public class Login{

	public static void login(){
		SignalToServer.sendMsg("logi");		
		if(UserData.userChecked) {
			PanelController.mainToLobbyPanel();
		} else {
			
			System.out.println("�α��� ������ �߸��Ǿ����ϴ�");
		}
	}
	
	
	
}