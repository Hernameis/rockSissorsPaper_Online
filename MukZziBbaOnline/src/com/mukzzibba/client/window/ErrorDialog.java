package com.mukzzibba.client.window;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;

import com.mukzzibba.client.button.ExitButton;

public class ErrorDialog extends Dialog{
	private static final long serialVersionUID = -5772609390448702755L;
	
	Label la;
	ExitButton exit;
	
	public ErrorDialog(String msg){
		this(msg, ClientFrame.getInstance());
	}
	
	public ErrorDialog(String msg, Window window) {
		super(window);
		
		this.setLayout(new BorderLayout());
		Label msgLabel=new Label(msg);
		msgLabel.setAlignment(Label.CENTER);
		
		Panel southPanel=new Panel(new BorderLayout());
		exit=new ExitButton("»Æ ¿Œ", this);
		southPanel.add(exit);
		
		add(msgLabel);
		add(southPanel, BorderLayout.SOUTH);
		
		setBounds(Location.startX()-100,Location.startY()-100,200,200);
		setVisible(true);
	}
	
}
