package com.test;

public class Test123 {
	static int findIdx3(int[] a,int low,int high) {
		if(low>high || high==a.length) return -1;
		int mid = (low+high)/2;
		if((low==mid&&a[mid]==3) ||(mid>0 && a[mid-1]==2&&a[mid]==3)) return mid;
		else if(a[mid-1]==3 && (a[mid]>=3))
			return findIdx3(a,low,mid-1);
		else return findIdx3(a,mid+1,high);
	}
	static int endIdx3(int[] a,int low,int high) {
		if(low>high || high==a.length) return -1;
		int mid = (low+high)/2;
		if((high==mid&&a[mid]==3) ||(mid<high && a[mid]==3&&a[mid+1]==5)) return mid;
		else if(a[mid]==3 && a[mid+1]==3)
			return endIdx3(a,mid+1,high);
		else return endIdx3(a,low,mid-1);
	}
	static int firstCheck(int[] a) {
		int n = a.length-1;
		if(a[0]==5 && a[n]==5) return 0;
		else if(a[0]==3 && a[n]==3) return n+1;
		else if(a[0]==2 && a[n]==2) return 0;
		else return -1;
	}
	public static void main(String[] args) {
		//int[] a = {2,2,2,2,2,3,3,3,3,3,5,5,5,5,5,5,5};
		//int[] a = {3,3,3,3,3,5,5,5,5,5,5,5};
		// int[] a = {5,5,5,5,5,5,5};
		int[] a = {2,2,2,2,2,5,5,5,5,5,5,5};
		int p = firstCheck(a);
		if(p!=-1)
			System.out.println(p);
		else {
			int st1 = findIdx3(a,0,a.length-1);
			int st2 = endIdx3(a,0,a.length-1);
			System.out.println(st2-st1+1);
		}

	}
}
