package com.test;

import java.util.Arrays;

public class S15 {
/*	static int find(int[] coins,int v) {
		if(v==0) return 0;
		int res = Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			if(coins[i]<=v) {
				int subres = find(coins,v-coins[i]);
				if(subres!=Integer.MAX_VALUE && res>subres+1)
					res = subres+1;
			}
		}
		return res;
	}*/
	static int find(int[] coins,int v){
		int[] s = new int[v+1];
		Arrays.fill(s, Integer.MAX_VALUE);
		s[0]=0;
		for(int i=1;i<s.length;i++) {
			for(int j=0;j<coins.length;j++) {
				if(coins[j]<=i){
					s[i] = Math.min(s[i], 1+s[i-coins[j]]);
				}
			}
		}
		return s[v];
	}
	public static void main(String[] args) {
		int[] coins = {9,6,5,1};
		int v=11;
		System.out.println(find(coins,v));
	}
}
