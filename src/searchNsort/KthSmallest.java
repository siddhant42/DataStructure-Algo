package searchNsort;

import java.util.PriorityQueue;

public class KthSmallest {
	static int find(int[] arr,int k) {
		if(arr==null || k>=arr.length) throw new 
		RuntimeException("k is greater than the # of elements in given array");
//		return qselect(arr,0,arr.length-1,k);
		return usingMaxHeap(arr,k);
	}
	private static int usingMaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k,(i,j)->j-i);
		for(int i=0;i<k;i++) pq.add(arr[i]);
		for(int i=k;i<arr.length;i++) {
			if(pq.peek()>arr[i]) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		return pq.peek();
	}
	static int qselect(int[] arr,int low,int high,int k) {
		if(low>high) return -1;
		if(low==high) return arr[low];
		int ub = partition(arr, low, high);
		if(ub==k-1) return arr[ub];
		else if(ub>k-1)
			return qselect(arr,low,ub-1,k);
		else
			return qselect(arr,ub+1,high,k);
	}
	private static int partition(int[] arr, int low, int high) {
		int rand = low+(int) (Math.random()*(high-low+1));
		int pivot = arr[rand];
		int lb=low,ub=high;
		while(lb<ub) {
			while(arr[lb]<=pivot && lb<high) lb++;
			while(arr[ub]>=pivot && ub>low) ub--;
			if(lb<ub) {
				swap(arr, lb, ub);
			}
		}
		if(lb<rand && arr[lb]>pivot) ub = lb;
		swap(arr, rand, ub);
		return ub;
	}
	private static void swap(int[] arr, int rand, int ub) {
		int tmp = arr[rand];
		arr[rand] = arr[ub];
		arr[ub] = tmp;
	}
	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 3, 20, 15};
	     int  k = 3;
	     System.out.println(find(arr,k));
	}
}
