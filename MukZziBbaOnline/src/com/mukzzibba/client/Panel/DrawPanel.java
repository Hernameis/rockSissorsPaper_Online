package com.mukzzibba.client.Panel;

import java.awt.GridLayout;
import java.awt.Panel;

import com.mukzzibba.client.button.DrawButton;

public class DrawPanel extends Panel{
	DrawButton rock;
	DrawButton scissors;
	DrawButton paper;
	
	public DrawPanel() {
		this.setLayout(new GridLayout(1,3));
		rock=new DrawButton("rock", "rock");
		scissors=new DrawButton("scissors", "scis");
		paper=new DrawButton("paper",  "pape");
		
		add(rock);
		add(scissors);
		add(paper);
	}
}
