package com.test2;
interface I1 {
	void m1();
}
public class Test4 implements I1 {
	public void m1(){
		System.out.println("Inside Test4.m1()");
	}
	public static void main(String[] args) {
		byte b = 7;
		b+=121;
		System.out.println(b);
		short s = (short)67.45;
		System.out.println(s);
		String t;
//		if(t==null)
//			System.out.println(t);
	}
}
