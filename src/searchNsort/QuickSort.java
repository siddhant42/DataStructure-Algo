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
		int pivot = a[low];
		int lb = low,ub = high;
		while(lb<ub) {
			while(a[lb]<=pivot && lb<high)
				lb++;
			while(a[ub]>=pivot && ub>low)
				ub--;
			if(ub==low) return;
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
		//int[] a = {4,87,23,1,54};
		int[] a = {7,10,4,3,20,15,18,25,30,1};
		sort(a);
		System.out.println(count);
		ArrayPrint.print(a);
	}
}
