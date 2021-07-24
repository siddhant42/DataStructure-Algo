package com.test;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class S13 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("I:/input.txt"));
		int max = 0;
		int n = sc.nextInt();
		int[] b = new int[n];
		for(int i=0;i<n;i++) {
			b[i] = sc.nextInt();
			if(max<b[i]) max = b[i];
		}
		long[] s = new long[max];
		new S13().find(max, s);
		for(int i=0;i<n;i++) {
			System.out.println(s[b[i]-1]);
		}
		sc.close();
	}
	void find(int max,long[] s) {
		int i=0,j=0,count=0;
		long sum=0;
		while(count<max) {
			sum = 0;
			int r=i,c=j;
			while(c<=r) {
				if(c!=r) 
					sum+=Math.pow(2, c)+Math.pow(2, r);
				else sum+=Math.pow(2, c);
				s[count++]=sum;
				if(count==max) break;
				c++;r--;
			}
			i++;
		}
		
	}

}
