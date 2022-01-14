package com.mukzzibba.client.window;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;

public class dupLoginDialog extends Dialog{
	
	Panel centerPanel;
	Panel southPanel;
	JButton yes;
	JButton no;
	
	public dupLoginDialog(){
		super(ClientFrame.getInstance(), "중복 로그인");
		
		setLayout(new GridLayout(2,1));
		centerPanel=new Panel(new GridLayout(2,1));
		southPanel=new Panel();
		
		Label msg1=new Label("중복 로그인이 감지되었습니다.");
		Label msg2=new Label("기존 접속을 끊고 종료하시겠습니까?");
		centerPanel.add(msg1);
		centerPanel.add(msg2);
		
		yes=new JButton("네");
		no=new JButton("아니오");
		
		southPanel.add(yes);
		southPanel.add(no);
		
		add(centerPanel);
		add(southPanel);
	}
}
