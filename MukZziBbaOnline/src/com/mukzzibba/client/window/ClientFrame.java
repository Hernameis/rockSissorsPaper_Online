package com.mukzzibba.client.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;







import com.mukzzibba.client.controller.PanelController;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.ChatManager;

public class ClientFrame extends Frame {
	private static final long serialVersionUID = 2932615732842895112L;
	
	public static Panel mainPanel;
	private static ClientFrame mainFrame;
	
	private ClientFrame() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				mainFrame.dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				UserData.end=true;
				try {
					if(UserData.mainSocket!=null){						
						UserData.mainSocket.close();
					}
					if(UserData.chatSocket!=null){
						UserData.chatSocket.close();
						ChatManager.closeChatStream();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		Toolkit tool=Toolkit.getDefaultToolkit();
		mainPanel=new Panel(new GridLayout(1,1));
		add(mainPanel);

		Dimension screenDimension;
		screenDimension=tool.getScreenSize();
		int screenX=(int)screenDimension.getWidth();
		int screenY=(int)screenDimension.getHeight();
		int frameWidth=500;
		int frameHeight=500;
		setBounds((screenX-frameWidth)/2,(screenY-frameHeight)/2,frameWidth,frameHeight);
		setVisible(true);
	}
	
	public static ClientFrame getInstance() {
		if (mainFrame==null) {			
			mainFrame=new ClientFrame();
		}
		return mainFrame;
	}
	
	public void start() {
		new PanelController();
	}
}
