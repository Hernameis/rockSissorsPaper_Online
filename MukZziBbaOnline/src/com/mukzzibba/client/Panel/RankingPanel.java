package com.mukzzibba.client.Panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.ToLobbyPanelButton;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;
import com.mukzzibba.server.userDb.UserInfo;

public class RankingPanel extends Panel{
	private static final long serialVersionUID = -3873288491609764479L;
	
	Frame frame;
	ExitButton exit;
	ToLobbyPanelButton back;
	public static ArrayList<UserInfo> list;
	
	public RankingPanel() {
		frame=ClientFrame.getInstance();
		this.setLayout(new BorderLayout());
		
		Panel titlePanel=new Panel(new GridLayout(1,7));
		titlePanel.add(new Label("����"));
		titlePanel.add(new Label("����"));
		titlePanel.add(new Label("�̸�"));
		titlePanel.add(new Label("��"));
		titlePanel.add(new Label("��"));
		titlePanel.add(new Label("��"));
		titlePanel.add(new Label("�·�"));
		
		Panel listPanel = new Panel(new GridLayout(11,1));
		for(int i=0; i<10; i++) {
			if(i < list.size()){
				JButton singleDataSet=new JButton();
				singleDataSet.setLayout(new GridLayout(1,7));
				UserInfo user=list.get(i);
				
				JLabel rank=new JLabel(""+(i+1));
				singleDataSet.add(rank);
				JLabel score=new JLabel(""+user.score);
				singleDataSet.add(score);
				JLabel name=new JLabel(user.nickname);
				singleDataSet.add(name);
				JLabel win=new JLabel(""+user.win);
				singleDataSet.add(win);
				JLabel draw=new JLabel(""+user.draw);
				singleDataSet.add(draw);
				JLabel lose=new JLabel(""+user.lose);
				singleDataSet.add(lose);
				JLabel rate=new JLabel(""+user.winRatio+"%");
				singleDataSet.add(rate);				
				listPanel.add(singleDataSet);
			} else {
				listPanel.add(new Panel());
			}
		}
		JButton myDataSet=new JButton();
		myDataSet.setBackground(new Color(255,255,204));
		myDataSet.setLayout(new GridLayout(1,7));
		myDataSet.add(new JLabel(""+(UserData.me.rank)));
		myDataSet.add(new JLabel(""+UserData.me.score));
		myDataSet.add(new JLabel(""+UserData.me.nickname));
		myDataSet.add(new JLabel(""+UserData.me.win));
		myDataSet.add(new JLabel(""+UserData.me.draw));
		myDataSet.add(new JLabel(""+UserData.me.lose));
		myDataSet.add(new JLabel(""+UserData.me.winRatio+"%"));
		listPanel.add(myDataSet);
		
		Panel buttonPanel=new Panel();
		buttonPanel.setLayout(new GridLayout(1,2));
		back=new ToLobbyPanelButton("�ڷ�");
		exit=new ExitButton("������", frame);
		buttonPanel.add(back);
		buttonPanel.add(exit);
		
		add(titlePanel, BorderLayout.NORTH);
		add(listPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
}
