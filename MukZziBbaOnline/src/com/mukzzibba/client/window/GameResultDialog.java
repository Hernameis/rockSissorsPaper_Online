package com.mukzzibba.client.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.data.ResultData;

public class GameResultDialog extends Dialog{
	private static final long serialVersionUID = 3208370987402624793L;
	
	Panel mainPanel;
	Label resultLabel;
	ResultData user;
	
	public GameResultDialog() {
		super(ClientFrame.getInstance(),true);
		mainPanel=new Panel(new BorderLayout());
		user=UserData.result;
		
		Panel resultPanel=new Panel(new GridLayout(3,1));
		resultPanel.add(new Button("����� "+enToKor(user.userStr)+"�� �°�"));
		resultPanel.add(new Button("���� "+enToKor(user.comStr)+"�� �½��ϴ�"));
		resultPanel.add(new Button(enToKor(user.result)));
		
		
		mainPanel.add(resultPanel, BorderLayout.CENTER);
		mainPanel.add(new ExitButton("�ݱ�", this), BorderLayout.SOUTH);
		add(mainPanel);
		setBounds(getMainLocation.startX()-100,getMainLocation.startY()-100,200,200);
		setVisible(true);
	}
	
	public static String enToKor(String eng){
		String msg="";

		if (eng.equals("rock")) {
			msg="����";
		} else if (eng.equals("scis")) {
			msg="����";
		} else if (eng.equals("pape")) {
			msg="��";
		} else if (eng.equals("win")) {
			msg="�¸�!!";
		} else if (eng.equals("draw")) {
			msg="���º�..";
		} else if (eng.equals("lose")) {
			msg="�й�Ф�";
		}
		return msg;
	}
}
