package com.mukzzibba.client.Panel;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;

import com.mukzzibba.client.button.DrawButton;

public class DrawPanel extends Panel{
	private static final long serialVersionUID = -8527384844859212210L;
	
	DrawButton rock;
	DrawButton scissors;
	DrawButton paper;
	
	public DrawPanel() {
		this.setLayout(new GridLayout(1,3));
		rock=new DrawButton("rock");
		rock.setIcon(new ImageIcon(".\\img\\ro.png"));
		scissors=new DrawButton("scis");
		scissors.setIcon(new ImageIcon(".\\img\\si.png"));
		paper=new DrawButton("pape");
		paper.setIcon(new ImageIcon(".\\img\\pa.png"));
		
		add(rock);
		add(scissors);
		add(paper);
	}
}
