package com.changhun.z.a_java_object;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		Map<Integer, Integer> lhMap = new LinkedHashMap<>();
		lhMap.put(1, 1);
		lhMap.put(3, 5);
		lhMap.put(2, 3);
		lhMap.put(3, 2);
		// It will maintain as insert order..
		
		Map<Integer, Integer> cMap = new HashMap<>();
		cMap.put(1, 1);
		cMap.put(3, 5);
		cMap.put(2, 3);
		cMap.put(3, 2);

		for (Entry<Integer, Integer> e : lhMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		System.out.println();

		for (Entry<Integer, Integer> e : cMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}
