package com.test;

import java.math.BigInteger;

public class BinaryPalindrome {
	static BigInteger find(int max) {
		int i=0,j=0,count=0;
		BigInteger sum = null;
		BigInteger two = new BigInteger(String.valueOf(2));
		while(count<max) {
			sum = new BigInteger(String.valueOf(0));
			int r=i,c=j;
			while(c<=r) {
				if(c!=r) 
					sum=sum.add(two.pow(c).add(two.pow(r)));
				else sum=sum.add(two.pow(c));
				count++;
				if(count==max) return sum;
				c++;r--;
			}
			i++;
		}
		return sum;
	}
	public static void main(String[] args) throws Exception {
/*		Scanner sc = new Scanner(new File("I:/input3.txt"));
		BufferedWriter bf = new BufferedWriter(new FileWriter("I:/output.txt"));
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		sc.close();
		for(int i=0;i<n;i++)
			bf.write(String.valueOf(find(a[i])));
		bf.close();*/
		System.out.println(find(392108155));
	}
	
}
