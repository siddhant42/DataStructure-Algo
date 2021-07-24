package searchNsort;

public class HeapSort {
	public static void sort(int[] a) {
		if(a==null || a.length==0 ||a.length==1) return;
		MinHeap heap = new MinHeap();
		for(int i=0;i<a.length;i++)
			heap.insert(a[i]);
		heap.printHeap();
		int k=0;
		while(!heap.isEmpty()) {
			a[k++]=heap.removeRootNode();
		}
	}
	public static void main(String[] args) {
		System.out.println("unsorted array ");
		int[] a = {4,87,23,1,54};
		sort(a);
		System.out.println("\nsorted array");
		ArrayPrint.print(a);
	}
}
