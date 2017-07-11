package com.core.staticdemo;

public class StaticTest {
	static StaticTest st = new StaticTest();
	int a = 110;
	static int b = 112;
	static {
		System.out.println("1");
	}

	{
		System.out.println("2");
	}

	public StaticTest() {
		System.out.println("3");
		System.out.println("a =" + a + ", b=" + b);
	}

	public static void main(String[] args) {

		staticFunection();
	}

	public static void staticFunection() {
		System.out.println("4");
	}

}
