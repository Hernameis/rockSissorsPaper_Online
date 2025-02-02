package com.mukzzibba.client.Panel;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.PlayButton;
import com.mukzzibba.client.button.RankingButton;
import com.mukzzibba.client.button.ToStartPanelButton;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.ClientFrame;

public class LobbyPanel extends Panel{
	private static final long serialVersionUID = -2473225825755910282L;
	
	Frame frame;
	PlayButton play;
	RankingButton rankboard;
	ToStartPanelButton goToStart;
	ExitButton exit;
	Panel infoPanel;
	Label infoLabel;
	
	public LobbyPanel() {
		frame=ClientFrame.getInstance();
		this.setLayout(new BorderLayout());
		
		Panel lobbyMainPanel=new Panel(new BorderLayout());
		infoPanel=new Panel(new GridLayout(3,1));
		Panel upperInfo=new Panel(new GridLayout(1,3));

		JButton userLabel=new JButton();
		ImageIcon userIcon=new ImageIcon(".\\img\\user.png");
		userLabel.setIcon(userIcon);
		upperInfo.add(userLabel);
		upperInfo.add(new Label(UserData.me.nickname));
		upperInfo.add(new Label());
		
		Panel centerInfo=new Panel(new GridLayout(1,5));
		centerInfo.add(new Label("����"));
		centerInfo.add(new Label("��"));
		centerInfo.add(new Label("��"));
		centerInfo.add(new Label("��"));
		centerInfo.add(new Label("�·�"));
		
		Panel southInfo=new Panel(new GridLayout(1,5));
		Label score=new Label(""+UserData.me.score);
		Label win=new Label(""+UserData.me.win);
		Label draw=new Label(""+UserData.me.draw);
		Label lose=new Label(""+UserData.me.lose);
		Label rate=new Label(""+UserData.me.winRatio+"%");
		southInfo.add(score);
		southInfo.add(win);
		southInfo.add(draw);
		southInfo.add(lose);
		southInfo.add(rate);
		
		infoPanel.add(upperInfo);
		infoPanel.add(centerInfo);
		infoPanel.add(southInfo);
		
		Panel selectPanel=new Panel(new GridLayout(4,1));
		Panel playPanel=new Panel(new GridLayout(1,3));
		play=new PlayButton("");
		ImageIcon playIcon=new ImageIcon(".\\img\\play.png");
		play.setIcon(playIcon);
		playPanel.add(play);
		Panel rankboardPanel=new Panel(new GridLayout(1,3));
		rankboard=new RankingButton("��ŷ");
		ImageIcon rankIcon=new ImageIcon(".\\img\\rank.png");
		rankboard.setIcon(rankIcon);
		rankboardPanel.add(rankboard);
		
		selectPanel.add(new Panel());
		selectPanel.add(playPanel);             
		selectPanel.add(rankboardPanel);
		selectPanel.add(new Panel());
		
		lobbyMainPanel.add(infoPanel, BorderLayout.NORTH);
		lobbyMainPanel.add(selectPanel, BorderLayout.CENTER);
		
		ChatPanel chatPanel=new ChatPanel();
		
		Panel exitPanel=new Panel(new GridLayout(1,2));
		goToStart=new ToStartPanelButton("ù ȭ��");
		exit=new ExitButton("���� ����", frame);
		exitPanel.add(goToStart);
		exitPanel.add(exit);
		
		add(new JPanel(), BorderLayout.NORTH);
		add(lobbyMainPanel, BorderLayout.CENTER);
		add(chatPanel, BorderLayout.EAST);
		add(exitPanel, BorderLayout.SOUTH);
		
	}
	
}
