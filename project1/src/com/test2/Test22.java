package com.test2;

import java.util.Scanner;

public class Test22 {
	long count=0;
	public boolean[] p = new boolean[8192];
	public int[] c = new int[1100];
	Test22(){
		c[0]=2;
		p[2] = true;
		int k=1;
		for(int i=3;i<8192;i+=2) {
			boolean b = true;
			int j=0;
			for(;c[j]<=(int)Math.sqrt(i);j++) {
				if(i%c[j]==0) {
					b = false;
					break;
				}
			}
			if(b) {
				p[i] = b;
				c[k++]=i;
			}
		}
	}
	 public void find(int[] a,int st,int n,int xor) {
	        if(p[xor]) count++;
	        if(st>=n) return;
	        for(int i=st;i<n;i++) {
	            find(a,i+1,n,xor^a[i]);
	        }
	    }
    public static void main(String[] args) {
    	Test22 obj = new Test22();
    	Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++)
            	a[j] = sc.nextInt();
            obj.find(a,0,n,0);
            System.out.println(obj.count);
        }
    }
}