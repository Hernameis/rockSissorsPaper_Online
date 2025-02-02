package com.mukzzibba.server.userDb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.server.socketNetwork.ReceiveDataFromClient;
import com.mukzzibba.server.socketNetwork.SendDataToClient;
import com.mukzzibba.util.RankingComparator;


public class UserDB {
	
	
	@SuppressWarnings("unchecked")
	public static TreeMap<String,UserInfo> readDBfromFile(){
		TreeMap<String,UserInfo> db=null;
		File file=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		file=new File("UserDB");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			makeFirstDb(file);
		}
		
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			db=(TreeMap<String,UserInfo>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return db;
	}
	
	public static void addToDBFile(UserInfo user){
		TreeMap<String,UserInfo> db=readDBfromFile();
		String key=new String(user.nickname);
		db.put(key, user);
		writeToFileDB(db);
	}
	
	public static void makeFirstDb(File file){
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		Map<String, UserInfo> empty=null;
		
		empty=new TreeMap<String, UserInfo>();
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(empty);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static UserInfo getUserFromFile(String name){
		TreeMap<String,UserInfo> db=null;
		db=readDBfromFile();
		UserInfo res=db.get(name);
		return res;
	}
	
	public static void updateSingleUser(String name, String gameResult){
		TreeMap<String,UserInfo> db=null;
		UserInfo user=null;

		db=readDBfromFile();
		user=getUserFromFile(name);		
		db.remove(name);
		db.put(name, user);
		user.updateResult(gameResult);		
		db.remove(name);
		db.put(name, user);
		
		UserDB.writeToFileDB(db);
	}
	
	public static void writeToFileDB(TreeMap<String,UserInfo> db){
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		File file;
		
		file=new File("UserDB");
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(db);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int returnRank(String name){
		System.out.println("��ũ int ����");
		UserInfo user=null;
		TreeMap<String,UserInfo> db=readDBfromFile();
		user=db.get(name);
		ArrayList<UserInfo> list=new ArrayList<>(db.values());
		list.sort(new RankingComparator());
		int i=0;
		for(i=0; i<list.size(); i++){
			if(list.get(i).nickname.equals(user.nickname)){
				break;
			}
		}
		return i;
	}
}
