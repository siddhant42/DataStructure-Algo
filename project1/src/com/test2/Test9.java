package com.test2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test9 {


    
	static void fib(int n,Map<Integer,BigInteger> bigMap,Set<Integer> set) {
		BigInteger big = new BigInteger("1");
		BigInteger big2 = new BigInteger("1");
		bigMap.put(1, big);
		bigMap.put(2,big2);
		int count=2;
		BigInteger big3 = null;
		for(int i=3;i<=n;i++) {
			big3 = big.add(big2);
			big = big2;
			big2 = big3;
			count++;
			if(set.contains(count))
				bigMap.put(count, big3);
		}
	}
	static BigInteger GCD(BigInteger a,BigInteger b,BigInteger zero) {
		int t = a.compareTo(b);
		if(t<0) return GCD(b,a,zero);
		if(a.mod(b).equals(zero)) return b; 
		return GCD(b,a.mod(b),zero);


	}
	static BigInteger findGCD(int[] a,int l,int r,Map<Integer,BigInteger> bigMap) {
		BigInteger result = bigMap.get(a[l]);
		BigInteger zero = new BigInteger("0");
		for(int i=l+1;i<=r;i++) {
			result = GCD(bigMap.get(a[i]),result,zero);
		}
		return result.mod(new BigInteger(String.valueOf((int)Math.pow(10, 9)+7)));
	}
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] a = new int[n];	        
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		int max=0;
		for(int i=0;i<n;i++) {
			if(max<a[i]) max = a[i];
		}
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			set.add(a[i]);
		}
		Map<Integer,BigInteger> bigMap = new HashMap<>();
			fib(max,bigMap,set);
			while(q>0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				BigInteger result = findGCD(a,l-1,r-1,bigMap);
				System.out.println(result);
				q--;
			
		}
	}

}