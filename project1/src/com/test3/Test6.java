package com.test3;

import java.util.Scanner;

public class Test6 {
	static void print(int n) {
		if(n<=0) {
//			char c = (char)(n+64);
//			System.out.println(c);
			return;
		}
		int x = n/26;
		int y = n%26;
		if(y==0) {
			y=26;
			x-=1;
		}
		print(x);
		char c = (char)(y+64);
		System.out.print(c);
	}
	public static void main(String[] args) {
		int n = 26*26*26;
		print(n);
	/*	Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n<=0) break;
			print(n);
			
		}*/
	}
}
