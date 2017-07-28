package com.test2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test20 {
	BigInteger fact(long n) {
		if(n<=1) return new BigInteger("1");
		BigInteger result = new BigInteger("1");
		for(int i=2;i<=n;i++)
			result = result.multiply(new BigInteger(String.valueOf(i)));
		return result;
	}
	BigInteger find(long a,long b) {
		return fact(a+b).divide((fact(a).multiply(fact(b))));
	}
	BigInteger find(List<Long> a) {
		if(a.size()<=1) return new BigInteger("1");
		List<Long> list = new ArrayList<>();
		List<Long> list2 = new ArrayList<>();
		for(int i=1;i<a.size();i++) {
			if(a.get(i)<a.get(0))
				list.add(a.get(i));
			else
				list2.add(a.get(i));
		}
		return find(list).multiply(find(list2)).multiply(find(list.size(),list2.size()));
	}
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for(int i=0;i<t;i++) {
           int n = sc.nextInt();
           Long[] a = new Long[n];
           for(int j=0;j<n;j++)
           a[j] = sc.nextLong();
           Test20 obj = new Test20();
           BigInteger result = obj.find(Arrays.asList(a));
           BigInteger mod = new BigInteger("10");
        mod = mod.pow(9).add(new BigInteger("7"));
        System.out.println(result.mod(mod));
       }
    }
/*	long fact(long n) {
		if(n<=1) return 1;
		long result =1;
		for(int i=2;i<=n;i++)
			result*=i;
		return result;
	}
	long find(long a,long b) {
		return fact(a+b)/(fact(a)*fact(b));
	}
	long find(List<Long> a) {
		if(a.size()<=1) return 1;
		List<Long> list = new ArrayList<>();
		List<Long> list2 = new ArrayList<>();
		for(int i=1;i<a.size();i++) {
			if(a.get(i)<a.get(0))
				list.add(a.get(i));
			else
				list2.add(a.get(i));
		}
		return find(list)*find(list2)*find(list.size(),list2.size());
	}
	public static void main(String[] args) {
		Long[] a = {40000000000l ,20000000000l, 50000000000l, 60000000000l, 30000000000l};
		Test20 obj = new Test20();
		System.out.println(obj.find(Arrays.asList(a)));
	}*/
}
