package com.mukzzibba.client.controller;

import java.awt.Frame;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.ToLobbyButton;
import com.mukzzibba.client.window.ClientFrame;

public class RankingPanel extends Panel{
	Frame frame;
	ExitButton exit;
	ToLobbyButton back;
	
	public RankingPanel() {
		frame=ClientFrame.getInstance();
		
		back=new ToLobbyButton("�ڷ�");
		exit=new ExitButton("������", frame);
		
		add(back);
		add(exit);
	}
}