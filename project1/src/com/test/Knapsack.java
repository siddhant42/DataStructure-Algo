package com.test;

import java.util.Scanner;

public class Knapsack {
	 public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      int m =sc.nextInt();
	      while(m>0){
	      int n = sc.nextInt();
	      int sum = sc.nextInt();
	      //System.out.println(n+" "+sum);
	      int[] a = new int[n];
	      for(int i=0;i<n;i++){
	    	  a[i]=sc.nextInt();
	      }
	      Knapsack obj = new Knapsack();
	       int min=obj.find(a,sum,a.length);
	       System.out.println(sum-min);
	    }
	      sc.close();
	      }
	private int find(int[] a, int sum,int n) {
		int min=0;
		if(n==0) return sum;
		if(sum==0) return 0;
		else if(sum<0) return Integer.MAX_VALUE;
		if(sum>0) {
		min = Math.min(find(a,sum-a[n-1],n),find(a,sum,n-1));
		}
		return min;
		}
	}

