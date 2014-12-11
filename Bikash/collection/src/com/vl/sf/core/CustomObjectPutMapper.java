package com.vl.sf.core;

import java.util.*;

public class CustomObjectPutMapper {
	public static void main(String[] args) {
		Map map = new HashMap();
		Key k1=new Key("price", 100);
		map.put(k1, "Value");
		addElements(map);
	}
	public static void addElements(Map map) {
		Key k1 = new Key("price1", 200);
		//map.put(k1, "Ashok");
		String name = (String) map.get(k1);
		System.out.println(name);
		System.out.println(map);
	}
}
