package com.core.producer.cusotmer;

public class Clerk {
	int product;

	public synchronized void pruduceProuct() {
		while (product < 5) {
			product++;
			System.out.println("�����߿�ʼ������" + product);
			notifyAll();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void consumerProduct() {
		while (product > 0) {
			product--;
			System.out.println("-----�����߿�ʼ���ѣ�" + product);
			notifyAll();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
