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
import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;

public class StartPanel extends Panel{
	Frame frame;
	Button registerButton;
	Button loginButton;
	Button exitButton;
	LoginData loginData;
	
	public StartPanel() {
		frame=ClientFrame.getInstance();
		
		UserData.login=new LoginData();
		loginData=UserData.login;
		
		loginData.nickname=new TextField("�г���");
		loginData.password=new TextField("��� ��ȣ");
		registerButton=new RegisterButton("ȸ�� ����");
		loginButton=new LogInButton("�α���");
		exitButton=new ExitButton("������", frame);
		
		add(loginData.nickname);
		add(loginData.password);
		add(loginButton);
		add(registerButton);
		add(exitButton);
		
	}
	
}