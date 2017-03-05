package com.test;
interface I1 {

}
public class S2 implements I1{
	void m1(Object obj) {
		System.out.println("integer");
	}
	void m1(String s) {
		System.out.println("string");
	}

/*	void m1(Integer i) {
		
	}*/
	public static void main(String[] args) {
		String s1 = "surbhi";
		String s2 = "sur";
		String s3 = s2+"bhi";
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
	}
}
