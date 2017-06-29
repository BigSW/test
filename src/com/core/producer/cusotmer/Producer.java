package com.core.producer.cusotmer;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {
	/*Clerk clerk;
	  
	  public Producer(Clerk clerk) {     
	    this.clerk = clerk;
	  }

	  @Override
	  public void run() {
	    while(true){
	        clerk.pruduceProuct();
	    }
	  }*/
	 private int MaxSize;
	    private Queue<Integer> queue;
	  
	    public Producer(int maxSize, Queue<Integer> queue) {
	        MaxSize = maxSize;
	        this.queue = queue;
	    }
	  
	    
	   /* @Override
	    public void run() {
	        synchronized (queue) {
	            while (queue.size() < MaxSize) {
	                int value = new Random().nextInt();
	                System.out.println("生产者开始生产数据了:" + value);
	                queue.add(value);
	                 
	            }
	            queue.notifyAll();
	            try {
	                queue.wait();
	            } catch (InterruptedException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }*/
	    
	    @Override
	    public void run() {
	        synchronized (queue) {
	            while(true){
	                while(queue.size() == MaxSize) {
	                    try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	                }
	                int value = new Random().nextInt();
	                System.out.println("生产者开始生产数据了:" + value);
	                queue.add(value);
	                queue.notifyAll();
	            }
	        }
	    }
}
