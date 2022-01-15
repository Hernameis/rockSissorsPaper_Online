package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.controller.PanelController;
import com.mukzzibba.client.data.UserData;

public class ToLobbyPanelButton extends JButton{
	private static final long serialVersionUID = -5872250765070528211L;

	public ToLobbyPanelButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelController.mainToLobbyPanel();
				UserData.gameStart=0;
			}
		});
	}
}
