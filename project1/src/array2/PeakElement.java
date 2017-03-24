package array2;

public class PeakElement {
	public int find(int[] a) {
		if(a==null||a.length==0||a.length==1) return -1;
		else return findPick(a,0,a.length-1,a.length);
	}
	private int findPick(int[] a,int low,int high,int n) {
		if(low==high) return high;
		int mid = (low+high)/2;
		if(mid==0 && a[mid]>a[mid]+1) return mid;
		else if(mid==n-1 && a[mid]>a[mid-1]) return mid;
		else if(a[mid]>a[mid-1] && a[mid]>a[mid+1]) return mid;
		else if(mid>0 && a[mid-1]>a[mid]) 
			return findPick(a,low,mid-1,n);
		else
			return findPick(a,mid+1,high,n);
	}
	public static void main(String[] args) {
		PeakElement obj = new PeakElement();
		//int arr[] = {1, 3, 20, 4, 1, 0};
		int[] arr = {1,3,2,5};
		int p = obj.find(arr);
		if(p!=-1)
			System.out.println("peak element is "+arr[p]);
		else
			System.out.println("no peak element exist in the given array");
			
	}
}
