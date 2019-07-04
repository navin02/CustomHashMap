package com.ns.map;

public class Test {
	public static void main(String[] args) {
		CustomHashMap<Integer, String> customHashMap = new CustomHashMap<Integer, String>();
		customHashMap.put(null, "sdf");
		customHashMap.put(1, "navin");
		customHashMap.put(2, "shah");
		customHashMap.put(1, "shahNavin");
		System.out.println(customHashMap.get(2));
		customHashMap.remove(2);
		System.out.println(customHashMap.get(2));
		System.out.println(customHashMap.remove(2));
		customHashMap.display();
	}
}
