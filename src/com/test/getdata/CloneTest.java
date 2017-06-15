package com.test.getdata;

public class CloneTest implements Cloneable {
	private String name;
	private String sex;

	
	public CloneTest(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTest test1 = new CloneTest("aa","1");
		CloneTest test2 = test1;
		CloneTest test3 = (CloneTest) test1.clone();
		
		System.out.println(test1==test2);
		System.out.println(test1==test3);
		System.out.println(test2==test3);
		
		System.out.println(test1.equals(test2));
		System.out.println(test1.equals(test3));
		System.out.println(test2.equals(test3));
	}
}
