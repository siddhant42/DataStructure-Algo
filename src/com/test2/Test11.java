package com.test2;

import java.util.Scanner;

public class Test11 {
	public static void print(int[][] a,int m,int n) {
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void find(int[][] a,int m,int n,int k) {
        int stRow=0,stCol=0,endRow=m-1,endCol=n-1;
        while(stRow<=endRow && stCol<=endCol) {
            int t = k%(2*(endRow+endCol-stRow-stCol));
            int i=stRow,j=stCol;
            while(t>0) {
            	int tmp = a[i][j];
                while(i<endRow) {
                   int tmp2 = a[i+1][j];
                    a[i+1][j] = tmp;
                    tmp = tmp2;
                    i++;
                }
                while(j<endCol) {
                    int tmp2 = a[i][j+1];
                    a[i][j+1] = tmp;
                    tmp = tmp2;
                    j++;
                }
                while(i>stRow) {
                    int tmp2 = a[i-1][j];
                    a[i-1][j] = tmp;
                    tmp = tmp2;
                    i--;
                }
                while(j>stCol) {
                    int tmp2 = a[i][j-1];
                    a[i][j-1] = tmp;
                    tmp = tmp2;
                    j--;
                }
                t--;
            }
            stRow++;stCol++;endRow--;endCol--;
        }
        print(a,m,n);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        find(a,m,n,k);
    }
}
