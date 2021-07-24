package com.test;


public class S15 {
	// recursively
/*	public int find(int[] coins,int v){
		return find(coins,v,0);
	}
	private int find(int[] coins,int v,int st) {
		if(v==0) return 1;
		if(st>=coins.length||v<0) return 0;
		
		int count=0;
		for(int i=0;i*coins[st]<=v;i++) {
			count+=find(coins,v-i*coins[st],st+1);
		}
		return count;
	}*/
	// dynamically
	public int find(int[] coins,int v) {
		int[] s = new int[v+1];
		s[0]=1;
			for(int j=3;j<=v;j++)
				s[j]+=s[j-3];
			for(int j=5;j<=v;j++)
				s[j]+=s[j-5];
			for(int j=10;j<=v;j++)
				s[j]+=s[j-10];
		
		return s[v];
	}
	public static void main(String[] args) {
		int[] coins={3,5,10};
		int v=15;
		System.out.println(new S15().find(coins, v));
	}
}
