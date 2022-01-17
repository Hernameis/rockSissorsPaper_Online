package com.mukzzibba.client.Panel;

import java.awt.Panel;

import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.ClientFrame;

public class PanelController {
	
	public static void onlyPanelChange(Panel inputPanel){
		ClientFrame.mainPanel.removeAll();
		ClientFrame.mainPanel.add(inputPanel);
		ClientFrame.mainPanel.revalidate();
	}
}
