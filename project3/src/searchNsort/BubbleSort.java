package searchNsort;

public class BubbleSort {
	public static void sort(int[] a) {
		if(a==null || a.length==0 || a.length==1) return;
		int n = a.length,exchanges=0;
		for(int i=n-1;i>0;i--) {
			boolean b = true;
			for(int j=0;j<i;j++) {
				if(a[j]>a[j+1]) {
					int swap = a[j];
					a[j]=a[j+1];
					a[j+1] = swap;
					exchanges++;
					b = false;
				}
			}
			if(b) break;
		}
		System.out.println("no of exchanges "+exchanges);
	}
	public static void main(String[] args) {
		// int[] a = {4,87,23,1,54};
		int[] b = {1,2,3,4,5};
		sort(b);
		ArrayPrint.print(b);
	}
}
