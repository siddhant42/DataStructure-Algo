package searchNsort;

public class QuickSort {
	static int count = 0;
	public static void sort(int[] a) {
		if(a==null || a.length==0 || a.length==1) return;
		int low=0,high=a.length-1;
		sort(a,low,high);
	}
	public static void sort(int[] a,int low,int high) {
		if(low>=high) return;
		count++;
		int pi = partition(a, low, high);
		sort(a,low,pi-1);
		sort(a,pi+1,high);
	}
	private static int partition(int[] a, int low, int high) {
		int pivot = a[low];
		int lb = low,ub = high;
		while(lb<ub) {
			while(a[lb]<=pivot && lb<high)
				lb++;
			while(a[ub]>=pivot && ub>low)
				ub--;
			if(ub==low) break;
			if(lb<ub) {
				swap(a, lb, ub);
				lb++;
				ub--;
			}
		}
		swap(a, low, ub);
		return ub;
	}
	private static void swap(int[] a, int low, int ub) {
		int swap = a[low];
		a[low] = a[ub];
		a[ub] = swap;
	}
	public static void main(String[] args) {
		//int[] a = {4,87,23,1,54};
//		int[] a = {7,10,4,3,20,15,18,25,30,1};
//		int[] a = {5,9,6,8};
		int[] a = {10,80,30,90,50,40};
		sort(a);
		System.out.println(count);
		ArrayPrint.print(a);
	}
}
