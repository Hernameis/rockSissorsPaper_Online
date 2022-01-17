package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.Panel.LobbyPanel;
import com.mukzzibba.client.Panel.PanelController;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.ErrorDialog;

public class LogInButton extends JButton{
	private static final long serialVersionUID = -1693197377299631256L;

	public LogInButton(String name) {
		super(name);
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignalToServer.sendMsg("logi");
				if(UserData.userChecked==0){
					new ErrorDialog("로그인 성공");
					PanelController.onlyPanelChange(new LobbyPanel());
					SignalToServer.sendMsg("logi");
				} else if (UserData.userChecked==1) {
					new ErrorDialog("비밀번호가 틀렸습니다");
				} else if (UserData.userChecked==2) {
					new ErrorDialog("닉네임이 존재하지 않습니다");
				}
			}
		});
	}
}
