package com.test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test15 {

	Map<GCD,Integer> map = new HashMap<>(100000);
	public long find(int[] a,int n) {
		long  count = 0;
		for(int i=0;i<n;i++) {
			int g = a[i]; count++;
			for(int j=i+1;j<n;j++) {
				GCD obj = new GCD(g,a[j]);
				Integer p = map.get(obj);
				if(p==null) {
					p = gcd(g,a[j]);
					map.put(obj, p);
				}
				g=p;
				if(g==1) break;
				count++;
			}
		}
		return count;
	}
	public int gcd(int a,int b) {
		if(a>b) return gcd(b,a);
		Integer p = map.get(new GCD(a,b));
		if(p!=null) return p;
		if(b%a==0) return a;
		return gcd(b%a,a);
	}
	public static void main(String[] args) {
		Test15 obj = new Test15();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		sc.close();
		long result = obj.find(a, n);
		System.out.println(result);
	}

}
