package com.test2;

import java.util.Scanner;

public class Test12 {
	 public static boolean find(Character[][] a,char[][] s,int st,int n,boolean[][] b) {
	        if(st==n) return true;
	        for(int i=0;i<10;i++) {
	            for(int j=0;j<10;j++) {
	                if(a[i][j]=='-'||s[st][0]==a[i][j]) {
	                    int len = s[st].length;
	                    if(j+len<=10 ) {
	                        int k=j;
	                        for(;k<j+len;k++) {
	                            if(a[i][k]=='-'||a[i][k]==s[st][k-j])
	                                continue;
	                            else break;
	                        }
	                        if(k==j+len) {
	                            for(k=j;k<j+len;k++) {
	                                if(a[i][k]=='-')
	                                    a[i][k]=s[st][k-j];
	                                else b[i][k] = true;
	                            }
	                            if(find(a,s,st+1,n,b)) return true;
	                            for(k=j;k<j+len;k++) {
	                                if(!b[i][k]) a[i][k] = '-';
	                                else b[i][k] = false;
	                            }
	                        }
	                    }
	                    if(i+len<=10 ) {
	                        int k=i;
	                        for(;k<i+len;k++) {
	                            if(a[k][j]=='-'||a[k][j]==s[st][k-i])
	                                continue;
	                            else break;
	                        }
	                        if(k==i+len) {
	                            for(k=i;k<i+len;k++) {
	                                if(a[k][j]=='-')
	                                    a[k][j]=s[st][k-i];
	                                else b[k][j] = true;
	                            }
	                            if(find(a,s,st+1,n,b)) return true;
	                            for(k=i;k<i+len;k++) {
	                                if(!b[k][j]) a[k][j] = '-';
	                                else b[k][j] = false;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        return false;
	    }
	    public static void print(Character[][] a) {
	        for(int i=0;i<10;i++) {
	            for(int j=0;j<10;j++) {
	                System.out.print(a[i][j]);
	            }
	            System.out.println();
	        }
	    }
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        char[][] ch = new char[10][];
	        for(int i=0;i<10;i++) {
	            ch[i] = sc.next().toCharArray();
	        }
	        Character[][] ch2 = new Character[10][10];
	        for(int i=0;i<10;i++) {
	        	for(int j=0;j<10;j++)
	        		ch2[i][j] = ch[i][j];
	        }
	        String[] str = sc.next().split(";");
	        int n = str.length;
	        char[][] c = new char[n][];
	        for(int i=0;i<n;i++) 
	            c[i] = str[i].toCharArray();
	        boolean[][] b = new boolean[10][10];
	        if(find(ch2,c,0,n,b))
	        print(ch2);
	    }
}
