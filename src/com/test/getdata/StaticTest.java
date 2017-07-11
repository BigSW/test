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
		
		System.out.println("第1次输出！");
		print(map);

		System.out.println("第2次输出！");
		map.put("1", "1");
		map.put("2", "2");
		print(map);
		
		System.out.println("第3次输出！");
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
