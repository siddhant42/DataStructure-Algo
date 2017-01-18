package com.test;

import java.io.File;
import java.util.Scanner;

public class S12 {
	int n=50;
	int[][] a = new int[n][n];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("I:/input.txt"));
		int max = 0;
		int n = sc.nextInt();
		int[] b = new int[n];
		for(int i=0;i<n;i++) {
			b[i] = sc.nextInt();
			if(max<b[i]) max = b[i];
		}
		int[] s = new int[max];
		new S12().find(max, s);
		for(int i=0;i<n;i++) {
			System.out.println(s[b[i]-1]);
		}
		sc.close();
	}
	void find(int max,int[] s) {
		int i=0,j=n-1,count=0;
		outerLoop:
		while(i<n) {
			int r=0,c=n-1,g=i,h=j;
			while(r<=g) {
				a[g][c]=1;
				a[r][h]=1;
				g--;c--;r++;h++;
				int l=i,o=n-1,sum=0,t=0;
				while(l>=0) {
					sum+=Math.pow(2, t)*a[l][o];
					l--;o--;t++;
				}
				s[count++]=sum;
				if(count==max) break outerLoop;
			}
			i++;j--;
		}
	}
}
