package com.test2;

import java.util.TreeMap;

class Dog implements Comparable<Dog> {
	String color;
	int size;

	Dog(String c, int s) {
		color = c;
		size = s;
	}
	@Override
	public int compareTo(Dog o) {
		return this.color.compareTo(o.color);
	}
	public static void main(String[] args) {
        Dog d1 = new Dog("a", 1);
        Dog d2 = new Dog("b", 2);
        Dog d3 = new Dog("c", 3);
        Dog d4 = new Dog("d", 4);
        Dog d5 = new Dog("e", 5);

        Dog d = new Dog("c", 3);

        TreeMap<Dog, Integer> hm = new TreeMap<>();
        hm.put(d1, 10);
        hm.put(d2, 15);
        hm.put(d3, 5);
        hm.put(d4, 20);
        hm.put(d5, 25);

        System.out.println("value is :" + hm.get(d));
    }
}
