package searchNsort;

public class QuickSort {
	public static void sort(int[] a) {
		if(a==null || a.length==0 || a.length==1) return;
		int low=0,high=a.length-1;
		sort(a,low,high);
	}
	public static void sort(int[] a,int low,int high) {
		if(low>=high) return;
		int pivot = a[low];
		int lb = low,ub = high;
		while(lb<ub) {
			while(a[lb]<=pivot && lb<high)
				lb++;
			while(a[ub]>=pivot && ub>low)
				ub--;
			if(lb<ub) {
				int swap = a[lb];
				a[lb] = a[ub];
				a[ub] = swap;
			}
		}
		int swap = a[low];
		a[low] = a[ub];
		a[ub] = swap;
		sort(a,low,ub-1);
		sort(a,ub+1,high);
	}
	public static void main(String[] args) {
		int[] a = {4,87,23,1,54};
		sort(a);
		ArrayPrint.print(a);
	}
}
