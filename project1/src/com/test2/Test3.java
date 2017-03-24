package com.test2;

import java.math.BigInteger;

public class Test3 {
	static int add(int a,int b) {
		BigInteger b1 = new BigInteger(String.valueOf(a));
		BigInteger b2 = new BigInteger(String.valueOf(b));
		BigInteger sum = b1.add(b2);
		if(sum.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))<=0)
			return sum.intValue();
		else
			throw new RuntimeException("sum of integers are outside of integer range");
		
	}
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	System.out.println(add(Integer.MAX_VALUE,Integer.MAX_VALUE));
	}
}
