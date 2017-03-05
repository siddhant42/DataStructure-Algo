package searchNsort;

public class ArrayPrint {
	public static void print(int[] a) {
		if(a==null||a.length==0) return;
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
