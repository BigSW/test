package com.core.bank;

import java.util.ArrayList;

/**
 * 1.定义一个用于存储上一个客户号码的成员变量和用于存储所有等待服务的客户号码的队列集合。
  2.定义一个产生新号码的方法和获取马上要为之服务的号码的方法，这两个方法被不同的线程操作了相同的数据，所以，要进行同步。
 * @author bigsw
 *2017年7月11日
 */
public class NumberManager {
	private Integer lastNumber = 0;
	private ArrayList<Integer> queen = new ArrayList<Integer>();

	/**
	 * 产生一个新的号码
	 * 
	 * @return
	 */
	public synchronized Integer getNewNumber() {
		queen.add(++lastNumber);
		return lastNumber;
	}

	/**
	 * 生成一个即将服务的号码
	 * 
	 * @return
	 */
	public synchronized Integer fetchNumber() {
		if (queen.size() > 0) {
			return queen.remove(0);
		} else {
			return null;
		}
	}

}
