package com.test2;

import java.math.BigInteger;
import java.util.Scanner;

public class Test17 {
	public static long find(int a,int s,int sum) {
		if(sum==a) return 1;
		else if(sum>a) return 0;
		long res = 0;
		for(int i=s;i<=a;i++) {
			int p = a-sum;
			if(p/i<2) break;
			res+=find(a,i,sum+i);
		}
		return res;
	}
	    public static void main(String args[] ) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int i=0;i<t;i++) {
	        int a = sc.nextInt();
	        int s = sc.nextInt();
	        long result = find(a,s,0)+1;
	        long m = (long)Math.pow(10, 9) + 9;
	        System.out.println(result%m);
	    }
	    }
}
