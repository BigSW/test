package com.core.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private static int port = 1234;
	private static String ip = "127.0.0.1";

	public static void send(String expression) {
		send(port, expression);
	}

	private static  void send(int port2, String expression) {
		System.out.println("算术表达式为：" + expression);
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket(ip, port);
			new Thread(new MyHandler(socket)).start();
			/*in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println(expression);
			System.out.println("___结果为：" + in.readLine());*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 一下必要的清理工作
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			/*if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}*/
		}
	}
}
