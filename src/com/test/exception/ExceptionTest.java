package com.test.exception;

public class ExceptionTest {

	boolean testEx() throws Exception {
		boolean ret = true;
		try {
			ret = testEx1();
		} catch (Exception e) {
			System.out.println("testEx, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx, finally; return value=" + ret);
			return ret;
		}
	}

	boolean testEx1() throws Exception {
		boolean ret = true;
		try {
			ret = testEx2();
			if (!ret) {
				return true;
			}
			System.out.println("testEx1, at the end of try");
			return ret;
		} catch (Exception e) {
			System.out.println("testEx1, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx1, finally; return value=" + ret);
		}
	}

	boolean testEx2() throws Exception {
		boolean ret = true;
		try {
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) {
				c = b / i;
				System.out.println("i=" + i);
			}
			return true;
		} catch (Exception e) {
			System.out.println("testEx2, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx2, finally; return value=" + ret);
			return ret;
		}
	}

	public static int print() {
		int c = 1;
		try {
			c++;
			System.out.println("try执行中...");
			c = c + 100;
			return c; // --------1
		} catch (Exception e) {
			e.printStackTrace();
			// return c; //--------4
		} finally {
			c++;
			System.out.println("finally执行中...");
			return c; // --------2
		}
		 //return c; //---------3
	}

	public static void main(String[] args) {
		System.out.println(ExceptionTest.print());
		ExceptionTest testException1 = new ExceptionTest();
		try {
			testException1.testEx();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
