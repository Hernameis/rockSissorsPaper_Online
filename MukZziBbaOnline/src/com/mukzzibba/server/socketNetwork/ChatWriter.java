package com.mukzzibba.server.socketNetwork;

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
		onlineUsers=new HashSet<String>();
		strTosay=new LinkedList<String>();

	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(strTosay.peek()!=null){
				strToWrite=strTosay.poll();
				ite=onlineUsers.iterator();
				while(ite.hasNext()){
					name=ite.next();
					sock=userSockets.get(name);
					if(sock!=null && sock.isConnected()){
						bw=openWriteStream(sock);
						try {
							useBufferedStream(bw, strToWrite);
							useBufferedStream(bw, returnOnlineList());
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println(name+"�� ���� ���°� ������");
							continue;
						}						
					}
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
	
	private static void useBufferedStream(BufferedWriter bw, String msg) throws IOException{
		bw.write(msg);
		bw.newLine();
		bw.flush();
	}
	
	public static void addStrToQueue(String msg){
		strTosay.add(msg);
	}
	
	public static void addOnlineUser(String name, Socket sock){
		userSockets.put(name, sock);
		onlineUsers.add(name);
	}
	
	public static boolean isUserOnline(String name){
		System.out.println("name "+name);
		System.out.println("userSockets "+userSockets);
		if(userSockets.containsKey(name)){
			return true;
		}
		return false;
	}
	
	public static void removeUser(String name){
		userSockets.remove(name);
		onlineUsers.remove(name);
	}
	
	public static String returnOnlineList(){
		Iterator<String> ite=onlineUsers.iterator();
		String res="";
		while(ite.hasNext()){
			res+=ite.next()+" ";
		}
		return res;
	}
}
