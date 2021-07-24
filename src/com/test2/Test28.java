package com.test2;

import java.io.IOException;
import java.util.Scanner;

public class Test28 {
	public static void main(String[] args) throws IOException {
	      Scanner sc = new Scanner(System.in);
	      int n = sc.nextInt();
	      int[] a = new int[n];
	      for(int i=0;i<n;i++)
	      a[i] = sc.nextInt();
	      int t = sc.nextInt();
	      long max =0,maxval = 0; 
	      int prev = Integer.MAX_VALUE,count=1;
	      for(int i=0;i<t;i++) {
	          int p = sc.nextInt();
	          if(prev<p) {
	              count++;
	              if(maxval<a[p-1]) maxval = a[p-1];
	              max = Math.max(max,maxval*count);
	          }
	          else {
	              count=1;
	              maxval = a[p-1];
	              max = Math.max(maxval,max);
	          }
	          prev = p;
	          System.out.println(max);
	      }
	      sc.close();
	    }
}
