package com.test2;

import java.util.Scanner;

public class Test5 {
	 public static int find(char[][] a,int m,int n) {
	        int max = 0,count=0;
	        for(int i=0;i<m;i++) {
	            for(int j=0;j<n;j++) {
	                if(a[i][j]=='G') count++;
	            }
	        }
	        if(count==0||count==1) return 0;
	        else if(count==2) return 1;
	        else max = 1;
	        for(int i=1;i<m;i++) {
	            for(int j=1;j<n;j++) {
	                if(a[i][j]=='G')
	                    max = Math.max(max,findMax(a,i,j,m,n));
	            }
	        }
	        return max;
	    }
	    private static int findMax(char[][] a,int r,int c,int m,int n) {
	        boolean[][] b = new boolean[m][n];
	        boolean set = false;
	        int max = 0;
	        int r1 = maxCountNode(a,r,c,m,n,b,false);
	        for(int i=r;i<m;i++) {
	            int j = (i==r)?c+1:1;
	            for(;j<n;j++) {
	                if(a[i][j]=='G' && !b[i][j]){
	                    int r2 = maxCountNode(a,i,j,m,n,b,true);
	                    max = Math.max(max,r1*r2);
	                }
	                    
	            }
	        }
	        return max;
	    }
	    private static int maxCountNode(char[][] a,int r,int c,int m,int n,boolean[][] b,boolean set) {
	        int count = 1,st=1;
	        while(true) {
	            if(r-st<0||r+st>=m||c-st<0||c+st>=n||b[r-st][c]||b[r+st][c]||b[r][c-st]||b[r][c+st]||a[r-st][c]=='B'||a[r+st][c]=='B'||a[r][c-st]=='B'||a[r][c+st]=='B') break;
	            if(!set) {
	            b[r-st][c] = true;
	            b[r+st][c] = true;
	            b[r][c-st] = true;
	            b[r][c+st] = true;
	            }
	            st++;
	            count+=4;
	        }
	        return count;
	    }
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int m = sc.nextInt();
	        int n = sc.nextInt();
	        char[][] a = new char[m][n];
	        for(int i=0;i<m;i++) {
	            String str = sc.next();
	            a[i] = str.toCharArray();
	        }
	        sc.close();
	        int result = find(a,m,n);
	        System.out.println(result);
	    }
}
