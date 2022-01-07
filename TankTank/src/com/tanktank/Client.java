package com.tanktank;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Client extends Frame{
	Panel startPanel;

	Client(){
		startPanel=new Panel();
		startPanel.setLayout(new BorderLayout());
		
		String nameOfGame="TankTank";
		
		String makerOfGame="maker : �μ�ȣ";
		String pleasePressMsg="please press";
		Panel downPanel=new Panel();
		downPanel.setLayout(new GridLayout(2,1));
		Label gameMakerLabel=new Label(makerOfGame);
		gameMakerLabel.setAlignment(Label.CENTER);
		Button pleasePressButton=new Button(pleasePressMsg);
		pleasePressButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enterGameRobby();
			}
		});
		downPanel.add(pleasePressButton);
		downPanel.add(gameMakerLabel);
		
		Label gameNameLabel=new Label(nameOfGame);
		gameNameLabel.setAlignment(Label.CENTER);
		
		startPanel.add(gameNameLabel, BorderLayout.CENTER);
		startPanel.add(downPanel, BorderLayout.SOUTH);
		
		add(startPanel);
		setBounds(100,100,500,500);
		setVisible(true);
		this.setResizable(false);
	}
	
	private void enterGameRobby(){
		this.remove(startPanel);
		System.out.println("Robby entered");

		Panel robbyPanel=new Panel();
		
		Button playButton=new Button("play");
		Button rankingButton=new Button("ranking");
		Button exitButton=new Button("exit");
		
		robbyPanel.add(playButton);
		robbyPanel.add(rankingButton);
		robbyPanel.add(exitButton);
		
		this.add(robbyPanel);
	}
	
	public static void main(String[] args) {
		Client newGame=new Client();
	}

}
