package com.test.getdata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class StaticTest {
	public static HashMap<String, String> map;
	static{
		 map = new HashMap<String, String>();
		map.put("0", "0");
	}
	public static void main(String[] args) {
		
		System.out.println("��1�������");
		print(map);

		System.out.println("��2�������");
		map.put("1", "1");
		map.put("2", "2");
		print(map);
		
		System.out.println("��3�������");
		Add1.add();
		Add2.add();
		print(map);
		
		
	}
	private static void print(HashMap<String, String> map) {
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> entry = iterator.next();
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
	}
}
