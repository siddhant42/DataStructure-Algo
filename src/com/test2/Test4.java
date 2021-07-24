package com.test2;

import java.util.TreeMap;

interface I1 {
	void m1();
}
class A{
	int d;
	public A(int d) {
		this.d=d;
	}
}
public class Test4 implements I1 {
	public void m1(){
		System.out.println("Inside Test4.m1()");
	}
	static int a=5,b=0;
	static int m2() {
		try{
			int c=a/b;
			return 1;
		}catch(Exception e) {
			return 2;
		}finally{
			return 3;
		}
		
	}
	public static void main(String[] args) {
		//		byte b = 7;
		//		b+=121;
		//		System.out.println(b);
		//		short s = (short)67.45;
		//		System.out.println(s);
		//		String t;
		//		if(t==null)
		//			System.out.println(t);
		//		TreeMap<A,Integer> map = new TreeMap<>();
		//		A obj1 = new A(1);
		//		A obj2 = new A(2);
		//		map.put(obj2, 1);
		//		map.put(obj1, 2);
		//		System.out.println(map);
		System.out.println(m2());
		
	}
}
