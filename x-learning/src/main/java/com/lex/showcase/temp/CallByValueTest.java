package com.lex.showcase.temp;

import java.util.ArrayList;
import java.util.List;


public class CallByValueTest {

	public static void main(String[] args) {
		CallByValueTest obj = new CallByValueTest();
		
		System.out.println("================ Test primitive type");
		int value = 10;
		System.out.println(value);
		obj.add(value);
		System.out.println(value);
		
		System.out.println("================ Test immutable type");
		String str = "Jack";
		System.out.println(str);
		obj.changeValue(str);
		System.out.println(str);
		
		System.out.println("================ Test Object type");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		System.out.println(list);
		obj.changeObject(list);
		System.out.println(list);
	}

	
	void add(int value) {
		System.out.println(value);
		value = 1;
		System.out.println(value);
	}
	
	void changeValue(String str) {
		System.out.println(str);
		str = str + "is a boy!";
		System.out.println(str);
	}
	
	void changeObject(List<Integer> list) {
		System.out.println(list);
		list = new ArrayList<>();
		System.out.println(list);
	}
}
