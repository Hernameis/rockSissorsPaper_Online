package com.mukzzibba.client.Panel;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.ToLobbyPanelButton;
import com.mukzzibba.client.window.ClientFrame;

public class PlayPanel extends Panel{
	private static final long serialVersionUID = 4110044752827072888L;
	
	Frame frame;
	JButton me;
	JButton com;
	ExitButton exit;
	ToLobbyPanelButton toLobby;
	DrawPanel draw;
	
	public PlayPanel() {
		frame=ClientFrame.getInstance();
		this.setLayout(new GridLayout(5,1));
		
		Panel exitPanel=new Panel(new GridLayout(1,5));
		Panel comPanel=new Panel(new GridLayout(1,3));
		Panel vsPanel=new Panel(new GridLayout(1,3));
		DrawPanel userPanel=new DrawPanel();
		exitPanel=new Panel(new GridLayout(1,4));
		Panel emptyPanel=new Panel();
				
		toLobby=new ToLobbyPanelButton("뒤로");
		exit=new ExitButton("나가기", frame);
		exitPanel.add(toLobby);
		exitPanel.add(new Panel());
		exitPanel.add(new Panel());
		exitPanel.add(new Panel());
		exitPanel.add(exit);
		
		com=new JButton("컴");
		comPanel.add(new Panel());
		comPanel.add(com);
		comPanel.add(new Panel());
		
		vsPanel.add(new Panel());
		vsPanel.add(new JLabel("vs"));
		
		
		add(exitPanel);
		add(comPanel);
		add(vsPanel);
		add(userPanel);
		add(emptyPanel);
	}
}
