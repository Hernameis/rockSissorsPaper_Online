package com.mukzzibba.client.window;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import com.mukzzibba.client.Panel.PanelController;
import com.mukzzibba.client.Panel.StartPanel;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.ChatManager;

public class ClientFrame extends Frame {
	private static final long serialVersionUID = 2932615732842895112L;
	
	public static Panel mainPanel;
	private static ClientFrame mainFrame;
	
	private ClientFrame() {
		mainPanel=new Panel(new GridLayout(1,1));
		this.add(mainPanel);

		addWindowListener(new MainWindowAdapter());
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Dimension screenDimension=tool.getScreenSize();
		int screenX=(int)screenDimension.getWidth();
		int screenY=(int)screenDimension.getHeight();
		int frameWidth=500;
		int frameHeight=500;
		
		setBounds((screenX-frameWidth)/2,(screenY-frameHeight)/2,frameWidth,frameHeight);
		setVisible(true);
	}
	
	public void begin() {
		PanelController.onlyPanelChange(new StartPanel());
		
		UserData.chat=new TextArea("",5,25,TextArea.SCROLLBARS_VERTICAL_ONLY);
		UserData.chat.setEditable(false);
	}
	
	public static ClientFrame getInstance() {
		if (mainFrame==null) {			
			mainFrame=new ClientFrame();
		}
		return mainFrame;
	}
	
	class MainWindowAdapter extends WindowAdapter {
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
		}
	
}

