package com.test2;

public class Test2 {
	static int findSmallest(int[] a) {
		int i=0,n=a.length;
		while(i<n) {
			if(a[i]<=0) {
				a[i] = 0;
				i++;
				continue;
				}
			int eIdx = a[i];
			if(eIdx<n && a[eIdx]>0) {
				a[i] = a[eIdx];
				a[eIdx] = -1;
			}
			else {
				a[i]=0;
				i++;
			}
		}
		for(int j=0;j<n;j++) {
			if(a[j]<0) return j+1;
		}
		return n+1;
	}
	public static void main(String[] args) {
		int arr[] = {0, 10, 2, -10, -20};
		System.out.println(findSmallest(arr));
	}
}
