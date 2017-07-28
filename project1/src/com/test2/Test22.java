package com.test2;

public class Test22 {
	public static void main(String[] args) {
		int i=0;
		for(;i<50;i++){
			if(i==5) System.out.println(5);
			if(i==4) continue;
		}
		System.out.println(i);
	}
}
