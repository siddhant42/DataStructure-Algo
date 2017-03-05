package array;

import java.math.BigDecimal;

public class Median3 {
	public double findMedian(int[] a,int[] b) {
		return findMedian(a,0,a.length-1,b,0,b.length-1);
	}
	public double findMedian(int[] a,int l1,int h1,int[] b,int l2,int h2) {
		if(h1-l1==0) return (double)(a[l1]+b[l2])/2;
		else if(h1-l1==1) 
			return (double)(Math.max(a[l1], b[l2])+Math.min(a[h1], b[h2]))/2;
		double m1 = findMedian(a,l1,h1);
		double m2 = findMedian(b,l2,h2);
		if(m1==m2) return m1;
		int mid1 = (l1+h1)/2;
		if((h1-l1)%2!=0)
			mid1 = mid1+1;
		int mid2 = h2-(mid1-l1);
		if(m1<m2)
			return findMedian(a,mid1,h1,b,l2,mid2);
		else
			return findMedian(a,l1,mid1,b,mid2,h2);
	}
	private double findMedian(int[] a,int l,int h) {
		int mid = (l+h)/2;
		if((l+h)/2==0) return a[mid];
		return (double)(a[mid]+a[mid+1])/2;
	}
	public static void main(String[] args) {
		Median3 obj = new Median3();
//		int a1[] = {1, 3, 5, 11, 17};
//	    int a2[] = {9, 10, 11, 13, 14};
	int a1[] = {1,2,3,6};
    int a2[] = {4,6,8,10};
	    double med = obj.findMedian(a1, a2);
	    System.out.println(BigDecimal.valueOf(med));
	}
}
