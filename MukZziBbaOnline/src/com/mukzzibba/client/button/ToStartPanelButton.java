package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.Panel.PanelController;

public class ToStartPanelButton extends Button{
	private static final long serialVersionUID = 5914294359027670989L;

		public ToStartPanelButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelController.mainToStartPanel();
			}
		});
	}
}
