package com.core.reflect.model;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException, Exception {
		try {
			String path = "com.core.reflect.model.User";
			Class<?> class1 = Class.forName(path);
			Instance1(class1);
			Instance2(class1);
			getDeclareMethod(class1);
			invokeMethod(class1);
			getCompomentType();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过反射，获取数组相关信息、给数组的第一位重新设置值
	 */
	private static void getCompomentType() {
		int[] temp = { 1, 2, 3, 4, 5 };
		Class<?> componentType = temp.getClass().getComponentType();
		System.out.println("name:" + componentType.getName() + ",length:" + Array.getLength(temp));
		System.out.println("first num:" + Array.get(temp, 0));
		Array.set(temp, 0, 20);
		System.out.println("first num:" + Array.get(temp, 0));
	}

	/**
	 * 通过反射，直接调用该类的某个方法
	 * 
	 * @param class1
	 * @throws Exception
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private static void invokeMethod(Class<?> class1)
			throws Exception, IllegalArgumentException, InvocationTargetException, InstantiationException {
		try {
			Method method = class1.getMethod("print2", int.class, int.class);
			method.invoke(class1.newInstance(), 2, 2);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取对应类中的所有方法，通过得到这个方法：可以获取返回类型、方法名字、异常类型
	 * 
	 * @param class1
	 */
	private static void getDeclareMethod(Class<?> class1) {
		Method[] methods = class1.getDeclaredMethods();
		if (methods != null && methods.length > 0) {
			for (int i = 0; i < methods.length; i++) {
				String methodName = methods[i].getName();
				Class<?> returnType = methods[i].getReturnType();
				System.out.println(
						"methodName:" + methodName + ",type:" + returnType + ",modifiy:" + methods[i].getModifiers());
			}
		} else {
			System.out.println(class1 + "类中没有方法！");
		}
	}

	/**
	 * 通过构造方法，创建对象
	 * 
	 * @param class1
	 */
	private static void Instance2(Class<?> class1) {
		Constructor<?>[] constructors = class1.getConstructors();
		if (constructors != null && constructors.length > 0) {
			for (int i = 0; i < constructors.length; i++) {
				Class<?>[] parameterTypes = constructors[i].getParameterTypes();
				if (parameterTypes != null && parameterTypes.length > 0) {
					System.out.print("cons[" + i + "] (");
					for (int j = 0; j < parameterTypes.length; j++) {
						if (j == parameterTypes.length - 1) {
							System.out.println("parameterTypes:" + parameterTypes[i]);
						} else {
							System.out.println("parameterTypes:" + parameterTypes[i] + ",");
						}
					}
					System.out.println(")");
				}
			}
		}

		try {
			User newInstance2 = (User) constructors[0].newInstance();
			User newInstance = (User) constructors[1].newInstance("aa", "dd");
			System.out.println(newInstance2 + "," + newInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过set方法，创建对象
	 * 
	 * @param class1
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private static void Instance1(Class<?> class1) throws InstantiationException, IllegalAccessException {
		Object newInstance = class1.newInstance();
		if (newInstance instanceof User) {
			User user = (User) newInstance;
			user.setAge("11");
			user.setName("aa");
			System.out.println(user.toString());
		}
	}
}
