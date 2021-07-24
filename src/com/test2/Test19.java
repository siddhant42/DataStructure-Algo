package com.test2;

import java.util.Scanner;

public class Test19 {
	public static void find(long l,long r) {
		long result = 0;
		if(l%4==3)  l = l+1;
        else if(l%4==1) {
        		result = result^1^(l+2);
        		l = l+3;
        		}
        else if(l%4==2) { 
        	result = result^(l+1);
        	l = l+2;
        	}
		if(r-l>=1)
         result = result ^ ((r-l-1)/4+1)%2;
            l = r-((r-l+1)%8)+1;
            for(long i=l;i<=r;i++) {
            	if(i%4==0)
            		result = result^i;
            	else if(i%4==2)
            		result = result^(i+1);
            }
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
