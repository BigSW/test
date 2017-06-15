package com.test.singleton;

/**
 * 由于加载一个类时，其内部类不会被加载。这样保证了只有调用getInstance()时才会产生实例，控制了生成实例的时间，实现了延迟加载。
 * 并且去掉了synchronized，让性能更优，用static来确保唯一性。
 * 
 * @author songwei 2017年6月13日
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
