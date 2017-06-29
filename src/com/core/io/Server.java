package com.core.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static int port=1234;
	private static ServerSocket socket;
	
	public static void start() throws IOException{
		start(port);
	}

	private static void start(int port2) throws IOException {
		if(socket!=null)
			return;
		else{
			try {
				socket = new ServerSocket(port2);
				System.out.println("Server start,port:"+port2);
				while(true){
					Socket server = socket.accept();
					new Thread(new MyHandler(server));
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}/*finally {
				System.out.println("server close");
				socket.close();
				socket=null;
			}*/
		}
			
	}
	
}
