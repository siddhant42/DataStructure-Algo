package com.test;
class A31{
	static int a = 8;
/*	A31(){
		System.out.println("a in A31 = "+a);
	}*/
	A31(int i) {
		System.out.println("No-Arg Constructor of A31 "+i);
	}
	void m1(){
		System.out.println("inside m1 of A31");
	}
}
public class S18 extends A31 {
	int a = 10;
	public void A31(){
		System.out.println("a in S18 = "+a);
	}
	S18(){
		super(10);
	}
	S18(int i) {
		this();
	}
	void m1() {
		System.out.println("Object argument");
	}
	void m1(S18 s) {
		System.out.println("A31 object argument");
	}
/*	void m1(String s) {
		System.out.println("String argument");
	}*/
	public static void main(String... a) {
		S18 obj = new S18();
		//System.out.println(obj instanceof Object);
		//int b = new int;
		//obj.A31();
		//wobj.m1(5.5f);
//		A31 o = null;
//		obj.m1(o);
	}
}
