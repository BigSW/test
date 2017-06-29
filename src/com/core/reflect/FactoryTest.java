package com.core.reflect;


public class FactoryTest {
	public interface people{
		public abstract void sex();
	}
	
	public class man implements people{
		@Override
		public void sex() {
			System.out.println("man");
		}
		
	}
	public class woman implements people{
		@Override
		public void sex() {
			System.out.println("woman");
		}
		
	}
		public static Object getInstance(String className) throws InstantiationException, IllegalAccessException{
			Object obj = null;
			try {
				obj = Class.forName(className).newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return obj;
		}
	public static void main(String[] args) {
		try {
			Object object=FactoryTest.getInstance("com.core.reflect.FactoryTest.man");
			if(object instanceof people){
				people p =(people) object;
				p.sex();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
