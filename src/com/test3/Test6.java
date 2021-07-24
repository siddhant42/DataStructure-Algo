package com.test3;

import java.util.Scanner;

public class Test6 {
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
	    char[] s = pattern.toCharArray();
	        int[] ch = new int[s.length+1];
	        for(int i=0;i<ch.length;i++)
	            ch[i]=i+1;
	        int n = ch.length;
	        int i=n-2;
	        while(i>=0) {
	            if(s[i]=='M') {
	                int tmp = ch[i];
	                ch[i] = ch[i+1];
	                ch[i+1] = tmp;
	                int j=i+1;
	                while(j<=n-2 && s[j]=='M') {
	                    tmp = ch[j];
	                    ch[j]=ch[j+1];
	                    ch[j+1] = tmp;
	                    j++;
	                }
	            }
	            i--;
	        }
	        String str ="";
	        for(int j:ch) {
	            str+=j;
	        }
	        return Integer.parseInt(str);
	    }
	public static void main(String[] args) {
		String s= "M";
		System.out.println(findPossibleSmallestNumberMatchingPattern(s));
	}
}
