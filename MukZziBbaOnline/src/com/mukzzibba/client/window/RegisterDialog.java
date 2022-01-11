package com.mukzzibba.client.window;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import com.mukzzibba.client.button.ConfirmInRegisterButton;
import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.NicknameDupCheckButton;

public class RegisterDialog extends Dialog{
	Panel p;
	TextField nickname;
	TextField password;
	NicknameDupCheckButton dup;
	ConfirmInRegisterButton confirm;
	ExitButton exit;
	
	public RegisterDialog(Frame frame,boolean link) {
		super(frame, link);
		p=new Panel();
//		p.setLayout(null);
		
		nickname=new TextField("�г���");
		password=new TextField("��й�ȣ");
		dup=new NicknameDupCheckButton();
		confirm=new ConfirmInRegisterButton("Ȯ��",this);
		exit=new ExitButton("�ݱ�", this);
		
		p.add(nickname);
		p.add(dup);
		p.add(password);
		p.add(confirm);
		p.add(exit);
		add(p);
		setBounds(100,100,200,200);
		setVisible(true);
	}
}