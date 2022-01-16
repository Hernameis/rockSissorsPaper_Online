package com.mukzzibba.client.window;

import java.awt.Frame;

public class Location {
	
	private static Frame frame;
	
	public static int startX(){
		frame=ClientFrame.getInstance();
		return frame.getLocation().x+frame.getSize().width/2;
		
	}
	
	public static int startY(){
		frame=ClientFrame.getInstance();
		return frame.getLocation().y+frame.getSize().height/2;
	}
}
