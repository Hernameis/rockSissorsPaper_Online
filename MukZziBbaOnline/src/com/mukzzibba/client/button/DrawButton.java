package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.GameResultDialog;

public class DrawButton extends JButton{
	private static final long serialVersionUID = 2373009524572920076L;

	public DrawButton(String msg) {
		this("", msg);
	}
	
	public DrawButton(String name, String msg) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignalToServer.sendMsg(msg);
				new GameResultDialog();
			}
		});
	}
}
