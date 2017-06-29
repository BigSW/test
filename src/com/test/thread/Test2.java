package com.test.thread;

import javax.swing.plaf.SliderUI;

public class Test2 implements Runnable {
	private String name;

	public Test2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("name:" + name + ",num:" + i);
			try {
				Thread.sleep((int) (Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		public static void main(String[] args) {
			new Thread(new Test2("A")).start();
			new Thread(new Test2("B")).start();
		}
}
