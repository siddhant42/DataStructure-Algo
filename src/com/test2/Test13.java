package com.test2;

import java.io.File;
import java.util.Scanner;

public class Test13 {
	//int count = 0;
	public long find(long[] a,long sum,long k,int st) {
		if(sum>=k) {
			long result = (long)Math.pow(2, a.length-st)-1;
			return 1+result;
			}
		if(st>=a.length) return 0;
		long count = 0;
		for(int i=st;i<a.length;i++) {
			long p = sum;
			for(int j=i;j<a.length;j++) 
				p+=a[j];
			if(p<k) break;
			
			 count += find(a,sum+a[i],k,i+1);
		}
		return count;
	}
	public static void main(String[] args) throws Exception {
		Test13 obj = new Test13();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextLong();
		long k = sc.nextLong();
		
		long l1 = System.nanoTime();
		  long result = obj.find(a,0,k,0);
		//obj.find2(a, k);
		long l2 = System.nanoTime();
		System.out.println(l2-l1);
		System.out.println(result);
	}

}