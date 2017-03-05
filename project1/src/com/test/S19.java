package com.test;
class A121 {
	static int x ;
	public A121(){
		x++;
	}	
}
public class S19 {
	public static void main(String[] args) {
		A232 obj = new A232();
		obj.m1();
		A121[] s = new A121[15];
		for(int i=0;i<15;i++)
			s[i] = new A121();
		System.out.println(A121.x);
	}
}
class A232 {
	public void m1 (){
		A121[] s = new A121[10];
		for(int i=0;i<10;i++)
			s[i]= new A121();
	}
}