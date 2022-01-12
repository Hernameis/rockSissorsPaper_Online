package com.mukzzibba.client.Panel;

import java.awt.Frame;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.ToLobbyPanelButton;
import com.mukzzibba.client.window.ClientFrame;

public class RankingPanel extends Panel{
	Frame frame;
	ExitButton exit;
	ToLobbyPanelButton back;
	
	public RankingPanel() {
		frame=ClientFrame.getInstance();
		
		back=new ToLobbyPanelButton("�ڷ�");
		exit=new ExitButton("������", frame);
		
		add(back);
		add(exit);
	}
}
