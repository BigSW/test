package com.core.producer.cusotmer;

public class Clerk {
	int product;

	public synchronized void pruduceProuct() {
		while (product < 5) {
			product++;
			System.out.println("生产者开始生产：" + product);
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
			System.out.println("-----消费者开始消费：" + product);
			notifyAll();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
