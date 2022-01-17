package com.mukzzibba.util;

import java.io.IOException;
import java.net.Socket;

public class Closer {
	
	public static void closeSocket(Socket sock) {
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
