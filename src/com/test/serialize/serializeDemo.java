package com.test.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serializeDemo {
	public static void main(String[] args) throws Exception {
		Student user = new Student("tom", "男", 11);
		File file = new File("D:\\user.txt");
		Tobyte(user, file);
		System.out.println("序列化成功--");
		ToObject(file);
		System.out.println("end");
	}

	private static void ToObject(File file) throws Exception{
		if(file==null){
			return ;
		}
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois= new ObjectInputStream(fis);
	    Student student =(Student) ois.readObject();
	    fis.close();
		ois.close();
	    System.out.println("解析之后的name:"+student.getName());
	}

	private static void Tobyte(Student user, File file) throws IOException, FileNotFoundException {
		if (file.exists() || !file.exists()) {
			file.delete();
		}
		file.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

		objectOutputStream.writeObject(user);
		objectOutputStream.flush();
		objectOutputStream.flush();
		outputStream.close();
	}
}
