package com.core.producer.cusotmer;

import java.util.LinkedList;
import java.util.Queue;

/**一个生产者，一个消费者
 * @author bigsw
 *2017年6月29日
 */
public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		 int Max = 3;
	        Queue<Integer> queue = new LinkedList<Integer>();
	        Producer producer = new Producer(Max, queue);
	        Customer customer = new Customer(Max, queue);
	        producer.start();
	        customer.start();
	}
}
