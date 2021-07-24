package searchNsort;

public class InsertionSort {
	public static void sort(int[] a) {
		if(a==null || a.length==0 || a.length==1) return;
		int n = a.length;
		for(int i=1;i<n;i++) {
			int k = a[i];
			for(int j=i-1;j>=0;j--) {
				if(a[j]>k) {
					a[j+1] = a[j];
					a[j] = k;
				}
				else break;
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {4,87,23,1,54};
		sort(a);
		ArrayPrint.print(a);
	}
}
