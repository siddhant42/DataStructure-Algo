package com.test3;

import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	 public static void main(String[] args) throws IOException {
	       Scanner sc = new Scanner(System.in);
	       int t = sc.nextInt();
	      while(t>0) {
	          String p = sc.next();
	          String q = sc.next();
	          int n = sc.nextInt();
	          int[] a = new int[n];
	          for(int i=0;i<n;i++)
	          a[i] = sc.nextInt();
	          long result = find(p,q,n,a);
	          System.out.println(result);
	          t--;
	      }
	       sc.close();
	    }
	    static long find(String p,String q,int n,int[] a) {
	        int i=0,m=p.length(),l=q.length();
	        long result=0; 
	        while(i<=m-l) {
	            if(p.indexOf(q,i)==i) {
	                int max=a[i];
	                int k=i;i++;
	                while(i<=m-l && i<k+l) {
	                    if(p.indexOf(q,i)==i){
	                        if(max<a[i]) max=a[i];
	                    }
	                    i++;
	                }
	               result+=max; 
	            }
	           else i++;
	        }
	        return result;
	    }
}
