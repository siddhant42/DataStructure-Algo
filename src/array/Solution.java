package array;

import java.util.Scanner;

public class Solution {
	public Solution(){
		for(int i=0;i<=3;i++)
			sol[i]=i;
	}
	int getMin(int n){
		int s =(int) Math.sqrt(n);
		int min=Integer.MAX_VALUE;
		if(min>reduce(n-1)) min = reduce(n-1);
		for(int i=2;i<=s;i++){
			if(n%i==0){
				if(min>reduce(n/i))
					min=reduce(n/i);
			}
		}
		return min;
	}
	int reduce(int n){
		if(n==0) return 0;
		if(sol[n]!=0) return sol[n];
		sol[n]=1+getMin(n);
		return sol[n];
	}
	int[] sol = new int[100000];
	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
			for(int i=0;i<n;i++)
				System.out.println(obj.reduce(a[i]));
		sc.close();
	}
}
