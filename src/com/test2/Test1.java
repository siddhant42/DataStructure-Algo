package com.test2;

public class Test1 {
	static int findMin(int[] a,int st) {
		if(st>=a.length) return 1;
		int max = 0;
		for(int i=st;i<a.length;i++) {
			if(a[st]<a[i])
			max = Math.max(max, 1+findMin(a,i+1));
		}
		return max;
	}
	public static void main(String[] args) {
		int[] a = {3,10,2,1,20};
		System.out.println(findMin(a,0));
	}
}
