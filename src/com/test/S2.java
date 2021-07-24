package com.test;

public class S2 {
	public void swap(Integer a,Integer b){
		Integer c=a;
		a=b;
		b=c;
		System.out.println("swapped a & b are "+a+" "+b);
	}
public static void main(String... args) {	
	S2 obj = new S2();
	Integer a =3,b=4;
	obj.swap(a, b);
	System.out.println(a+" "+b);
}
 
}
