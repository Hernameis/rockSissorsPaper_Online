package com.mukzzibba.client.controller;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import javax.activation.DataContentHandler;
import javax.xml.crypto.Data;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.LogInButton;
import com.mukzzibba.client.button.RegisterButton;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;

public class StartPanel extends Panel{
	Frame frame;
	TextField nickname;
	TextField password;
	Button registerButton;
	Button loginButton;
	Button exitButton;
	
	public StartPanel() {
		frame=ClientFrame.getInstance();
		
		nickname=new TextField("닉네임");
		password=new TextField("비밀 번호");
		registerButton=new RegisterButton("회원 가입");
		loginButton=new LogInButton("로그인");
		exitButton=new ExitButton("나가기", frame);
		
		add(nickname);
		add(password);
		add(loginButton);
		add(registerButton);
		add(exitButton);
		
	}
	
}
