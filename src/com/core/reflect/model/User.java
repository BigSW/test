package com.core.reflect.model;

public class User {
	private String name;
	private String age;

	public User() {
	}

	public User(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public void print1(){
		System.out.println("public print1");
	}
	public  void print2(int a,int b){
		System.out.println("private print2:"+(a+b));
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
