package com.test2;

import java.io.IOException;
import java.util.Scanner;

public class Test25 {
	//int max = 0;
	public static void main(String[] args) throws IOException {
		Test25 obj = new Test25();
	       Scanner sc = new Scanner(System.in);
	       int n = sc.nextInt();
	       int[] a = new int[n];
	       int xor = 0;
	       for(int i=0;i<n;i++) {
	         a[i] = sc.nextInt();
	         xor = xor^a[i];
	       }
	       obj.solve(a,n,xor);
	    }
	     void solve(int[] a,int n,int xor){
	        int l = 0; 
	        for(int i=0;i<n;i++)
	         l = Math.max(l,a[i]);
	         int[] b = new int[l+1];
	         for(int j=0;j<=l;j++) {
	        	 b[j] = findJ(a,0,xor,j,0);
	             System.out.println(b[j]);
	         }
	         long ans = 0;
	        for(int j=0;j<=l;j++) 
	        ans += b[j] * Math.pow(31,j);
	        ans = ans%1000000007;
	        System.out.println(ans);
	    
	    }
	    public int findJ(int[] a,int st,int xor,int j,int count) {
	       int n = a.length,max = 0;
	       if(xor==j) return n;
	       for(int i=0;i<n;i++) {
	    	   int p = xor;
	    	   for(int k=n-1;k>i;k--) {
	    		   p = p^a[k];
	    		   if(p==j) max = Math.max(max, k-i);
	    	   }
	    		xor = xor^a[i];   
	       }
	       return max;
	    }
}
