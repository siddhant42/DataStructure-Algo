package com.test;

public class MyOuter2 {
	private String x = "Outer2";
	void m1(Object obj) {
			System.out.println(obj.toString());
	}
	void doStuff() {
		//int p=8;
		String x2="myInner2";
		class MyInner {
			public void seeOuter() {
				m1(this);
				System.out.println(x2);
				System.out.println("Outer x is " + x);
			} // close inner class method
		} // close inner class definition
		MyInner mi = new MyInner(); // This line must come
		// after the class
		mi.seeOuter();
	}
	public static void main(String[] args) {
		new MyOuter2().doStuff();
	}
}
