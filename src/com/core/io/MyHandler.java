package com.core.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyHandler implements Runnable {
	private Socket socket;

	public MyHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in=null;
		PrintWriter out= null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			 in = new BufferedReader(inputStreamReader);
			out=new PrintWriter(socket.getOutputStream(), true);
			String expression;
			String result;
			while(true){
				if(((expression=in.readLine())==null))
					break;
				System.out.println("服务器接收到消息："+expression);
				 try{  
	                    result = Calculator.cal(expression).toString();  
	                }catch(Exception e){  
	                    result = "计算错误：" + e.getMessage();  
	                }  
	                out.println(result); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out!=null){
				out.close();
				out=null;
			}
			if(socket!=null){
				try {
					socket.close();
					socket=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
