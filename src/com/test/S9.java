package com.test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class S9 {
	public static void main(String[] args) {
		Map<Integer,Integer> map = new TreeMap<>();
		map.put(7, 9);
		map.put(54, 23);
		map.put(4, 89);
		map.put(1, 654);
		map.put(2, 34);
		Set<Integer> s = map.keySet();
		for(int i:s)
			System.out.print(i+" ");
		
	}
}
