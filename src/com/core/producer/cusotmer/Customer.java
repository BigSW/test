package com.core.producer.cusotmer;

import java.util.Queue;

public class Customer extends Thread {
	 private int MaxSize;
	    private Queue<Integer> queue;
	 
	    public Customer(int maxSize, Queue<Integer> queue) {
	        MaxSize = maxSize;
	        this.queue = queue;
	    }
	 
	 /*   @Override
	    public void run() {
	        synchronized (queue) {
	            while(queue!=null&&queue.size()>0){
	                System.out.println("--------消费者开始消费数据："+queue.remove());
	            }
	            queue.notifyAll();
	            try {
	                queue.wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }*/
	    @Override
	    public void run() {
	    	synchronized (queue) {
				while(true){
					while(queue!=null&&queue.size()>0){
						 System.out.println("--------消费者开始消费数据："+queue.remove());
						 queue.notifyAll();
					}
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					
					
				}
			}
	    }
}
