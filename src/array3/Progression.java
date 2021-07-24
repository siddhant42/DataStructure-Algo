package array3;

import java.util.Scanner;

public class Progression {
	public static void find(int[] a){
		int i,n=a.length,diff,prod;
		if(a==null||n<3){
			System.out.println("can't determine the next element");
			return;
		}
		diff=a[1]-a[0];
		for(i=2;i<n;i++){
			if(a[i]-a[i-1]!=diff) break;
		}
		if(i==n){
			System.out.println(a[n-1]+diff+" is the next element");
			return;
		}
		prod=a[1]/a[0];
		for(i=2;i<n;i++){
			if(a[i]/a[i-1]!=prod) break;
		}
		if(i==n){
			System.out.println(a[n-1]*prod+" is the next element");
			return;
		}
		for(i=2;i<n;i++){
			if(a[i-2]+a[i-1]!=a[i]) break;
		}
		if(i==n){
			System.out.println(a[n-2]+a[n-1]+" is the next element");
			return;
		}
		System.out.println("the given no.s are not in these sequence");
	}
public static void main(String[] args) {
	int i,n;
	System.out.println("how many elements do you want to enter in aaray");
	Scanner sc=new Scanner(System.in);
	n=sc.nextInt();
	int[] a=new int[n];
	System.out.println("enter the numbers");
	for(i=0;i<n;i++){
		a[i]=sc.nextInt();
	}
	find(a);
}
}
