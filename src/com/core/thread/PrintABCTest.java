package com.core.thread;

public class PrintABCTest implements Runnable {
	private Object preVal;
	private Object currentVal;
	private String name;

	public PrintABCTest(String name, Object preVal, Object currentVal) {
		this.preVal = preVal;
		this.currentVal = currentVal;
		this.name = name;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (preVal) {
				synchronized (currentVal) {
					System.out.print(name);
					count--;
					currentVal.notify();
				}
				try {
					preVal.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		PrintABCTest t1 = new PrintABCTest("A", c, a);
		PrintABCTest t2 = new PrintABCTest("B", a, b);
		PrintABCTest t3 = new PrintABCTest("C", b, c);

		new Thread(t1).start();
		Thread.sleep(100);
		new Thread(t2).start();
		Thread.sleep(100);
		new Thread(t3).start();
		Thread.sleep(100);
	}
}
