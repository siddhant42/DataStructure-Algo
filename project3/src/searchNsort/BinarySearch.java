package searchNsort;
/**
 * Given a binary array sorted in non-increasing order,
 * count the number of 1’s in it.
 * 
 * @author kumarsid
 *
 */
public class BinarySearch {
	// search the starting Index of 1 in a binary array of 0 & 1
	public static int binarySearch(int[] a,int low,int high) {
		if(low>high || a==null) return -1;
		if(low==high && a[low]==1) return low;
		int mid = (low+high)/2;
		if(mid>0 && a[mid]==1 && a[mid-1]==0) return mid;
		else if(a[mid]==1) 
			return binarySearch(a,low,mid-1);
		else return binarySearch(a,mid+1,high);
	}
	public static int find(int[] a) {
		if(a==null) return -1;
		int n = a.length;
		if(a[0]==0 && a[n-1]==0) return 0;
		else if(a[0]==1 && a[n-1]==1) return a.length;
		int low = 0, high = n-1;
		int st = binarySearch(a,low,high);
		if(st!=-1) return n-st;
		else return 0;
	}
	public static void main(String[] args) {
		int[] a = {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
		int count = find(a);
		System.out.println(count);
	}
}
