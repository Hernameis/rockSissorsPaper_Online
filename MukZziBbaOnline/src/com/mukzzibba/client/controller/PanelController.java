package com.mukzzibba.client.controller;

import com.mukzzibba.client.Panel.LobbyPanel;
import com.mukzzibba.client.Panel.PlayPanel;
import com.mukzzibba.client.Panel.RankingPanel;
import com.mukzzibba.client.Panel.StartPanel;
import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.ClientFrame;

public class PanelController {
	
	public PanelController() {
		mainToStartPanel();
	}
	
	public static void mainToStartPanel(){
		ClientFrame.mainPanel.removeAll();
		ClientFrame.mainPanel.add(new StartPanel());
		ClientFrame.mainPanel.revalidate();
	}
	
	public static void mainToLobbyPanel() {
		SignalToServer.sendMsg("logi");
		ClientFrame.mainPanel.removeAll();
		ClientFrame.mainPanel.add(new LobbyPanel());
		ClientFrame.mainPanel.revalidate();
	}
	
	public static void mainToRankingPanel() {
		ClientFrame.mainPanel.removeAll();
		ClientFrame.mainPanel.add(new RankingPanel());
		ClientFrame.mainPanel.revalidate();
	}
	
	public static void mainToPlayPanel() {
		ClientFrame.mainPanel.removeAll();
		ClientFrame.mainPanel.add(new PlayPanel());
		ClientFrame.mainPanel.revalidate();
	}
}
