package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.Panel.PanelController;

public class ToLobbyPanelButton extends Button{
	
	public ToLobbyPanelButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelController.mainToLobbyPanel();
			}
		});
	}
}