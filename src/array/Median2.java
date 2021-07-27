package array;

import java.math.BigDecimal;

public class Median2 {
	public double findMedian(int[] nums1,int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (findkth(nums1,0,nums2,0,l)+findkth(nums1,0,nums2,0,r))/2.0;
	}

    double findkth(int[] a1,int st1,int[] a2,int st2,int k) {
        if(st1>=a1.length) return a2[st2+k-1];
        if(st2>=a2.length) return a1[st1+k-1];
        if(k==1) return (double)(Integer.min(a1[st1],a2[st2]));
        
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(st1+k/2-1<a1.length) mid1 = a1[st1+k/2-1];
        if(st2+k/2-1<a2.length) mid2 = a2[st2+k/2-1];
        if(mid1<mid2) {
            return findkth(a1,st1+k/2,a2,st2,k-k/2);
        } else {
            return findkth(a1,st1,a2,st2+k/2,k-k/2);
        }
    }
	public static void main(String[] args) {
		Median2 obj = new Median2();
		int a1[] = {1,2,3};
		int a2[] = {4,5,6,7,8};
		//		int a1[] = {1,2,3,6};
		//	    int a2[] = {4,6,8,10};
		double med = obj.findMedian(a1, a2);
		System.out.println(BigDecimal.valueOf(med));
	}
}
