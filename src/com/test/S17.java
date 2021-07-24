package com.test;

public class S17 {
	int p = 0;
	final String s = "sid";
	 void m1(){
		synchronized(s) {
		p++;
		System.out.println(p);
	}
	}
	public static void main(String[] args) {
		S17 obj1 = new S17();
		S17 obj2 = new S17();
		new Thread(){
			public void run(){
				obj1.m1();
			}
		}.start();
		new Thread(){
			public void run(){
				obj2.m1();
			}
		}.start();
	}
}
