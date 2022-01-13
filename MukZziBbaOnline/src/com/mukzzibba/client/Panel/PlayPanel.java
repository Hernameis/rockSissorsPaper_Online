package com.mukzzibba.client.Panel;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.ToLobbyPanelButton;
import com.mukzzibba.client.window.ClientFrame;

public class PlayPanel extends Panel{
	private static final long serialVersionUID = 4110044752827072888L;
	
	Frame frame;
	Button me;
	Button com;
	ExitButton exit;
	ToLobbyPanelButton toLobby;
	DrawPanel draw;
	
	public PlayPanel() {
		frame=ClientFrame.getInstance();
		me=new Button("나");
		com=new Button("컴");
		toLobby=new ToLobbyPanelButton("뒤로");
		exit=new ExitButton("나가기", frame);
		draw=new DrawPanel();
		
		add(me);
		add(com);
		add(toLobby);
		add(exit);
		add(draw);
	}
}
