package searchNsort;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] a) {
		if(a==null || a.length==0 || a.length==1) return;
		int low=0,high=a.length-1;
		sort(a,low,high);
	}
	private static void sort(int[] a,int low,int high) {
		if(low>=high) return;
		int mid = (low+high)/2;
		sort(a,low,mid);
		sort(a,mid+1,high);
		merge(a,low,mid,high);
	}
	public static void merge(int[] a,int low,int mid,int high) {
		int n1 = mid-low+1;
		int n2 = high-mid;
		int[] b = Arrays.copyOfRange(a, low, mid+1);
		int[] c = Arrays.copyOfRange(a, mid+1, high+1);
		
		int i=0,j=0,k = low;
		while (i<n1 && j<n2) {
			if(b[i]<c[j])
				a[k++] = b[i++];
			else
				a[k++] = c[j++];
		}
		while (i<n1)
			a[k++] = b[i++];
		while (j<n2)
			a[k++] = c[j++];
	}
	public static void main(String[] args) {
		int[] a = {4,87,23,1,54};
		sort(a);
		ArrayPrint.print(a);
	}
}
