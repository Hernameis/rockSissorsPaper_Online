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
import com.mukzzibba.server.ResultData;

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
		resultPanel.add(new Button("당신은 "+enToKor(user.userStr)+"를 냈고"));
		resultPanel.add(new Button("컴퓨터는 "+enToKor(user.comStr)+"를 냈습니다"));
		resultPanel.add(new Button(enToKor(user.result)));
		
		
		mainPanel.add(resultPanel, BorderLayout.CENTER);
		mainPanel.add(new ExitButton("닫기", this), BorderLayout.SOUTH);
		add(mainPanel);
		setBounds(100,100,200,200);
		setVisible(true);
	}
	
	public static String enToKor(String eng){
		String msg="";

		if (eng.equals("rock")) {
			msg="바위";
		} else if (eng.equals("scis")) {
			msg="가위";
		} else if (eng.equals("pape")) {
			msg="보";
		} else if (eng.equals("win")) {
			msg="이겼습니다!!";
		} else if (eng.equals("draw")) {
			msg="비겼습니다..";
		} else if (eng.equals("lose")) {
			msg="졌습니다ㅠㅠ";
		}
		return msg;
	}
}
