package com.mukzzibba.client.Panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.ChatWriter;
import com.mukzzibba.client.socketNetwork.SignalToServer;

public class ChatPanel extends Panel{
	private static final long serialVersionUID = 454647050883126278L;
	
	Panel mainPanel;
	Panel southPanel;
	Panel writePanel;
	TextArea showChat;
	JTextField toWrite;
	SendButton send;
	JButton startChat;
	JButton exit;
	
	Panel listPanel;
	JTextArea onlineList;
	
	public ChatPanel(){
		this.setLayout(new BorderLayout());
		mainPanel=new Panel(new BorderLayout());
		startChat=new JButton("채팅 채널 들어가기");
		startChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserData.isChat=1;
				SignalToServer.sendMsg("chat");
				startChat.setEnabled(false);
				startChat.setText("접속 중");
				send.setEnabled(true);
				toWrite.setEditable(true);
			}
		});
		
		showChat=UserData.chat;
		
		southPanel=new Panel(new GridLayout(1,1));
		writePanel=new Panel(new BorderLayout());
		UserData.toWrite=new JTextField();
		toWrite=UserData.toWrite;
		toWrite.setText("");
		if(UserData.isChat==0){
			toWrite.setEditable(false);			
		}
		toWrite.addActionListener(new ChatSendAction());
		
		send=new SendButton("전송");
		if(UserData.isChat==0){
			send.setEnabled(false);			
		}
		writePanel.add(toWrite, BorderLayout.CENTER);
		writePanel.add(send, BorderLayout.EAST);
		
		southPanel.add(writePanel);
		
		mainPanel.add(startChat, BorderLayout.NORTH);
		mainPanel.add(showChat, BorderLayout.CENTER);
		mainPanel.add(southPanel ,BorderLayout.SOUTH);
		
		listPanel=new Panel(new BorderLayout());
		UserData.chatList=new JTextArea();
		onlineList=UserData.chatList;
		listPanel.add(onlineList, BorderLayout.CENTER);
		listPanel.add(new JButton("온라인"), BorderLayout.NORTH);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(listPanel, BorderLayout.EAST);
		this.add(new JButton("접속 중인 서버 : "+UserData.serverIp), BorderLayout.SOUTH);
	}
	
	public class SendButton extends JButton{
		
		public SendButton(String name){
			super(name);
			addActionListener(new ChatSendAction());
		}
	}
	
	public class ChatSendAction implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ChatWriter.sayToAll(UserData.toWrite.getText());
			UserData.toWrite.setText("");
		}
	}
}
