package com.test;

public class S11 {
	void fact(int n) {
		if(n<=0) return;
		int size = 0;
		int[] a = new int[100];
		a[size++]=1;
		while(n>0) {
			int rem=0;
			for(int i=0;i<size;i++) {
				int p = n*a[i]+rem;
				a[i]=p%10;
				rem = p/10;
			}
			while(rem>0) {
				a[size++]=rem%10;
				rem = rem/10;
			}
			n--;
		}
		print(a,size);
	}

	private void print(int[] a, int size) {
		if(a==null||a.length==0) return;
		for(int i=size-1;i>=0;i--)
			System.out.print(a[i]);
	}

	public static void main(String[] args){
		S11 obj = new S11();
		System.out.println(Math.random());
		System.out.println(Math.random());
	}
}