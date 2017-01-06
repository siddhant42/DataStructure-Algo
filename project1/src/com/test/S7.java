package com.test;
enum Ab1{
	ONE,TWO;
}
public class S7 {
public static void main(String[] args) {
	Ab1 obj = Ab1.ONE;
	System.out.println(obj==Ab1.ONE);
	System.out.println(obj.equals(Ab1.ONE));
}
}
