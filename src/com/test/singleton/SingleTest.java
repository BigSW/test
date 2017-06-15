package com.test.singleton;

/**
 * ���ڼ���һ����ʱ�����ڲ��಻�ᱻ���ء�������֤��ֻ�е���getInstance()ʱ�Ż����ʵ��������������ʵ����ʱ�䣬ʵ�����ӳټ��ء�
 * ����ȥ����synchronized�������ܸ��ţ���static��ȷ��Ψһ�ԡ�
 * 
 * @author songwei 2017��6��13��
 */
public class SingleTest {
	private SingleTest() {
		System.out.println("signle create..");
	}

	private static class SingleHolder {
		private static SingleTest instance = new SingleTest();
	}

	public static SingleTest getInstance() {
		return SingleHolder.instance;
	}

	public static void main(String[] args) {
		System.out.println(SingleTest.getInstance());
	}
}
