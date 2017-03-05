package searchNsort;
/**
 * Given a sorted array containing only 2,3 & 5,
 * count the number of 3’s in it.
 * 
 * @author Siddhant Kumar
 *
 */
public class BinarySearch2 {
	// method to find the starting index of integer k
	public static int findStartingIndex(int[] a,int low,int high,int k) {
		if(a==null || low>high) return -1;
		else if(low==high && a[low]==k) return low;
		int mid = (low+high)/2;
		if(mid>0 && a[mid]==k && a[mid-1]<k) return mid;
		else if(a[mid]<k) 
			return findStartingIndex(a,mid+1,high,k);
		else 
			return findStartingIndex(a,low,mid-1,k);
	}
	// method to find end index of integer k
	public static int findEndIndex(int[] a,int low,int high,int k) {
		if(a==null || low>high) return -1;
		else if(low==high && a[high]==k) return high;
		int mid = (low+high)/2;
		if(mid<(a.length-1) && a[mid]==k && a[mid+1]>k) 
			return mid;
		else if(a[mid]>k)
			return findEndIndex(a,low,mid-1,k);
		else
			return findEndIndex(a,mid+1,high,k);
	}
	public static int find(int[] a,int k) {
		if(a==null) return 0;
		int n = a.length;
		int low=0,high=n-1;
		int st = findStartingIndex(a,low,high,k);
		int et = findEndIndex(a,low,high,k);
		if(st!=-1 && et!=-1) return et-st+1;
		else return 0;
	}
	public static void main(String[] args) {
		int[] a1 = {2,2,2,2,3,3,3,5,5,5,5,5};
		int[] a2 = {3,3,3,5,5,5,5,5};
		int[] a3 = {2,2,2,2,3,3,3};
		int[] a4 = {3,3,3};
		int[] a5 = {2,2,2,2,5,5,5,5,5};
		int k = 3;
		//int count = find(a,k);
		System.out.println(find(a1,k));
		System.out.println(find(a2,k));
		System.out.println(find(a3,k));
		System.out.println(find(a4,k));
		System.out.println(find(a5,k));
	}
}
