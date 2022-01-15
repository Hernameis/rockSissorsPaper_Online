package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.controller.PanelController;

public class PlayButton extends JButton{
	private static final long serialVersionUID = 4890041370110902987L;

	public PlayButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelController.mainToPlayPanel();
			}
		});
	}
}
