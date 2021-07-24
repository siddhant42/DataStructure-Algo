package array;

import java.math.BigDecimal;

/**
 * To find median with two sorted and same length array.
 * @author kumarsid
 *
 */
public class Median1 {
	public double findMedian(int[] a,int[] b) {
		if(a==null||a.length==0) return 0;
		return findMedianRec(a,0,a.length-1,b,0,b.length-1);
	}
	private double findMedianRec(int[] a1,int l1,int h1,int[] a2,int l2,int h2) {
		int mid1 = (l1+h1)/2;
		int mid2= (l2+h2)/2;
		if(h1-l1==0) {
			return ((double)a1[l1]+a2[l2])/2;
		}
		else if(h1-l1==1) {
			return ((double)Math.max(a1[l1], a2[l2]) + Math.min(a1[h1], a2[h2]))/2;
		}
		double m1 = median(a1,l1,h1);
		double m2 = median(a2,l2,h2);
		if(m1==m2) return m1;
		else if(m1<m2) {

			if((h2-l2+1)%2==0) h2 = mid2 + 1;
			else h2 = mid2;
			return findMedianRec(a1,mid1,h1,a2,l2,h2);
		}
		else {

			if((h1-l1+1)%2==0) h1 = mid1+1;
			else h1 = mid1;
			return findMedianRec(a1,l1,h1,a2,mid2,h2);
		}  
	}
	private double median(int[] a,int l, int h) {
		int med = (l+h)/2;
		if((h-l+1)%2==0){
			return ((double)a[med]+a[med+1])/2;
		}
		return a[med];
	}
	public static void main(String[] args) {
		Median1 obj = new Median1();
//		   int a1[] = {1, 3, 5, 11, 17};
//		    int a2[] = {9, 10, 11, 13, 14};
		int a1[] = {1,2,3,6};
	    int a2[] = {4,6,8,10};
		    double med = obj.findMedian(a1, a2);
		    System.out.println(BigDecimal.valueOf(med));
	}
}
