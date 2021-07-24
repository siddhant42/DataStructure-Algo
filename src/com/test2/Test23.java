package com.test2;

import java.util.Scanner;

public class Test23 {
	 public static boolean find(int[] a,int n) {
	        if(a==null || a.length==0) return false;
	        long sum = a[0];
	        return find(a,sum,String.valueOf(sum),1,n);
	    }
	    private static boolean find(int[] a,long sum,String str,int st,int n) {
	        if(st<n){
	         if(sum>0 &&(sum+a[st]<0 || sum*a[st]<0)) return false;
	 	        else if(sum<0 &&(sum-a[st]>0 || sum*a[st]>0)) return false;
	        }
	        else if(st==n){
	        if(sum%101==0){
	            System.out.println(str);
	            return true;
	        }
	            else return false;
	        }
	        	if(find(a,sum*a[st],str+"*"+a[st],st+1,n)) return true;
	        	else if(find(a,sum+a[st],str+"+"+a[st],st+1,n)) return true;
	            else if(find(a,sum-a[st],str+"-"+a[st],st+1,n)) return true;
	            
	            else  return false;
	    }
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)
	            a[i] = sc.nextInt();
	        sc.close();
	        boolean b = find(a,n);
	            if(!b) System.out.println("no solution exists");
	    }
}
