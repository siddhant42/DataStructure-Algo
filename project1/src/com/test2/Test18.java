package com.test2;

import java.util.Scanner;

public class Test18 {
	 static long _find(long l,long r) {
	        long result = 0;
	        for(long i=l;i<=r;i+=4)
	            result = result ^ i;
	        for(long i=l+2;i<=r;i+=4)
	            result = result ^ (i+1);
	        result = result ^ ((r-l-1)/4+1)%2;
	        return result;
	    }
	    public static void find(long l,long r) {
	        long result = 0;
	        if((r-l+1)<=5) {
	            for(long i=l;i<=r;i++)
	                result = result ^ i;
	            System.out.println(result);
	            return;
	        }
	        if(l%4==3) result = result ^ _find(l+1,r);
	        else if (l%4==0) result = result ^ _find(l,r);
	        else if(l%4==1) result = result ^ 1 ^ (l+2) ^ _find(l+3,r);
	        else result = result ^ (l+1) ^ _find(l+2,r);
	        System.out.println(result);
	    }
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int Q = in.nextInt();
	        for(int a0 = 0; a0 < Q; a0++){
	            long L = in.nextLong();
	            long R = in.nextLong();
	            find(L,R);
	        }
	    }
}
