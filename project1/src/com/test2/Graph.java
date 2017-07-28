package com.test2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	LinkedList<Integer>[] nodes;
	public Graph(int len) {
		nodes = new LinkedList[len+1];
		for(int i=1;i<=len;i++)
			nodes[i] = new LinkedList<>();
	}
	boolean[] primes = new boolean[200001];
	int[] p = new int[18000];
	public void setPrimes() {
		primes[2] = true;
		int size = 0;
		p[size++] = 2;
		for(int i=3;i<200000;i+=2) {
			primes[i] = true;
			for(int j=0;p[j]<=(int)Math.sqrt(i);j++) {
				if(i%p[j]==0) {
					primes[i] = false;
					break;
				}
			}
			if(primes[i]) p[size++] = i;
		}
	}
	public void addEdge(int a,int b) {
		nodes[a].add(b);
		nodes[b].add(a);
	}
	public long traverse(int a,int b,int n) {
		boolean[] traversed = new boolean[n+1];
		return traverse(a,b,0,traversed);
	}
	public long traverse(int a,int b,long count,boolean[] traversed) {
		if(!traversed[a]) {
			traversed[a] = true;
			if(primes[a]) count++;
			if(a==b) return count;
		}
		Iterator<Integer> itr = nodes[a].listIterator();
		while(itr.hasNext()) {
			int p = itr.next();
			if(!traversed[p]) {
			long c = traverse(p,b,count,traversed);
			if(c!=0) return c;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Graph obj = new Graph(n);
		obj.setPrimes();
		for(int i=0;i<n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			obj.addEdge(a, b);
		}
		int q = sc.nextInt();
		for(int i=0;i<q;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long result = obj.traverse(a, b, n);
			System.out.println(result);
		}
		sc.close();
	}
}