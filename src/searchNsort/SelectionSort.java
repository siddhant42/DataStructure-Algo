package searchNsort;
/**
 * Program to sort an array using selection sort
 * Worst Time Complexity: o(n-square)
 * @author Siddhant Kumar
 *
 */
public class SelectionSort {
	public static void sort(int[] a) {
		if(a==null||a.length==0||a.length==1) return;
		int n = a.length;
		for(int i=0;i<n-1;i++) {
			int lowest = i;
			for(int j=i;j<n;j++) {
				if(a[lowest]>a[j])
					lowest = j;
			}
			if(lowest!=i) {
				int swap = a[lowest];
				a[lowest] = a[i];
				a[i] = swap;
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {4,87,23,1,54};
		sort(a);
		ArrayPrint.print(a);
	}
}
