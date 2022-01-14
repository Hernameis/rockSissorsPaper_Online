package com.mukzzibba.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ChatWriter extends Thread{
	
	private static HashMap<String, Socket> userSockets;
	private static HashSet<String> onlineUsers;
	Iterator<String> ite;
	
	private static Queue<String> strTosay;
	private Socket sock;
	String strToWrite;
	String name;
	
	BufferedWriter bw;
	
	public ChatWriter(){
		userSockets=new HashMap<String, Socket>();
		System.out.println("1 "+userSockets);
		strTosay=new LinkedList<String>();
		while(true) {
			if(!strTosay.isEmpty()){
				strToWrite=strTosay.poll();
				ite=onlineUsers.iterator();
				while(ite.hasNext()){
					name=ite.next();
					sock=userSockets.get(name);
					bw=openWriteStream(sock);
					useBufferedStream(bw, strToWrite);
				}
			}
		}
	}
	
	private static BufferedWriter openWriteStream(Socket sock){
		OutputStream os =null;
		OutputStreamWriter osw=null;
		BufferedWriter bw=null;
		
		try {
			os=sock.getOutputStream();
			osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bw;
	}
	
	private static void useBufferedStream(BufferedWriter bw, String msg){
		try {
			bw.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addStrToQueue(String msg){
		strTosay.add(msg);
	}
	
	public static void addOnlineUser(String name, Socket sock){
		userSockets.put(name, sock);
	}
	
	public static boolean isUserOnline(String name){
		System.out.println("name "+name);
		System.out.println("userSockets "+userSockets);
		if(userSockets.containsKey(name)){
			return true;
		}
		return false;
	}
}
