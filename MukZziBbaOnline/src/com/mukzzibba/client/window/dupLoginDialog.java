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
		super(ClientFrame.getInstance(), "�ߺ� �α���");
		
		setLayout(new GridLayout(2,1));
		centerPanel=new Panel(new GridLayout(2,1));
		southPanel=new Panel();
		
		Label msg1=new Label("�ߺ� �α����� �����Ǿ����ϴ�.");
		Label msg2=new Label("���� ������ ���� �����Ͻðڽ��ϱ�?");
		centerPanel.add(msg1);
		centerPanel.add(msg2);
		
		yes=new JButton("��");
		no=new JButton("�ƴϿ�");
		
		southPanel.add(yes);
		southPanel.add(no);
		
		add(centerPanel);
		add(southPanel);
	}
}