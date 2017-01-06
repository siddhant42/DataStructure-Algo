package com.test;


class S1 {
	private int x=6;
	public  S1(){
		System.out.println("inside myouter class");
	}
	public void myouter(){
				S2 obj2 = new S2();
				obj2.m1();
	}
	private class S2 extends S5 {
		public  S2(){
			System.out.println("inside myinner class");
		}
		void m1(){
			System.out.println("Outer x is " + x);
			System.out.println("Inner class ref is " + this);
			System.out.println("Outer class ref is " + S1.this);
		}
	}
	public static void main(String[] args) {
		S1.S2 obj=new S1().new S2();
		obj.m1();
		//S1 obj2 = new S1();
	}
}