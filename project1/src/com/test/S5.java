package com.test;

public class S5 {
public static void main(String[] args) {
	Integer a = 7;
	Integer b = 9;
	System.out.println("original a is "+a+" original b is "+b);
//	a = a+b;
//	b = a-b;
//	a = a-b;
	new S5().swap(a,b);
	System.out.println("a is "+a+" b is "+b);
}

private void swap(Integer a, Integer b) {
Integer c = a;
a = b;
b = c;
}
}
