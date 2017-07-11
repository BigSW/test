package com.core.thread_join;

public class JoinTest extends Thread {
	private String name;

	public JoinTest(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(this.currentThread().getName() + "start!");
		for (int i = 0; i < 5; i++) {
			System.out.println("×ÓÏß³Ì:" +this.currentThread().getName()+ "start-" + i);
			/*try {
				sleep((int) (Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		System.out.println(this.currentThread().getName() + "end!");
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "start!");
		JoinTest test = new JoinTest("A");
		JoinTest test2 = new JoinTest("B");
		test.start();
		test.setPriority(Thread.MAX_PRIORITY);
		test2.start();
		test2.setPriority(Thread.MIN_PRIORITY);
		try {
			System.out.println("before join currentThread is :"+Thread.currentThread().getName());
			test.join();
			test2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "end!");
	}
}
