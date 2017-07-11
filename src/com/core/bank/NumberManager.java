package com.core.bank;

import java.util.ArrayList;

/**
 * 1.����һ�����ڴ洢��һ���ͻ�����ĳ�Ա���������ڴ洢���еȴ�����Ŀͻ�����Ķ��м��ϡ�
  2.����һ�������º���ķ����ͻ�ȡ����ҪΪ֮����ĺ���ķ�������������������ͬ���̲߳�������ͬ�����ݣ����ԣ�Ҫ����ͬ����
 * @author bigsw
 *2017��7��11��
 */
public class NumberManager {
	private Integer lastNumber = 0;
	private ArrayList<Integer> queen = new ArrayList<Integer>();

	/**
	 * ����һ���µĺ���
	 * 
	 * @return
	 */
	public synchronized Integer getNewNumber() {
		queen.add(++lastNumber);
		return lastNumber;
	}

	/**
	 * ����һ����������ĺ���
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
