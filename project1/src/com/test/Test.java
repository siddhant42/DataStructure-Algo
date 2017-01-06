package com.test;
class I{
	
	public I(){
		
		System.out.println("in classI constructor");
	}
	public void finalize(){
		System.out.println("finalize of sup I is called");
	}
}
class Test extends I {
	//private final Object obj2 = new Object();
	private final I obj = new I();
	public  Test(String i){
		
		System.out.println(i);
	}
	public void finalize(){
		//super.finalize();
		System.out.println("finalize of sub Test is called");
		
	}
public static void main(String[] args) {
Test obj = new Test("1");
obj=null;
//obj.finalize();
}
}
