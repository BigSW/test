package com.test.thread;

public class Test1 extends Thread {
	private String name;

	public Test1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("name:" + name + ",num:" + i);
			try {
				 sleep((int) Math.random() * 10);  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Test1 t = new Test1("A");
		Test1 t2 = new Test1("B");
		t.start();
		t2.start();
	}
}
