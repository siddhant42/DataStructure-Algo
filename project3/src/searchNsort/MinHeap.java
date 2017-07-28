package searchNsort;

import java.util.Arrays;

public class MinHeap {
	private static final int DEFAULT_CAPACITY = 16;
	private int size,capacity;
	private float loadFactor = 0.75f;
	private int[] arr;
	public MinHeap(int initialCapacity) {
		capacity = initialCapacity;
		arr = new int[capacity];
	}
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	private boolean resize() {
		int max = Integer.MAX_VALUE;
		if(capacity<= max/2) {
			capacity = 2*capacity;
			arr = Arrays.copyOf(arr, capacity);
			return true;
		}
		else if(capacity!=max) {
			capacity = max;
			arr = Arrays.copyOf(arr, capacity);
			return true;
		}
		return false;
	}
	public void insert(int data) {
		if(size>= capacity*loadFactor) {
			if(!resize()) return;
		}
		int loc = size++;
		insert(data,loc);
	}
	private void insert(int data, int loc) {
		int par = (loc-1)/2;
		while(loc>0) {
			if(arr[par]<data) {
				arr[loc] = data;
				return;
			}
			arr[loc] = arr[par];
			loc = par;
			par = (loc-1)/2;
		}
		arr[0] = data;
	}
	public Integer removeRootNode() {
		if(arr==null || size==0)
			return null;
		return removeNode(0);
	}
	public Integer removeNode(int pos) {
		if(arr==null || size==0 || pos>=size)
			return null;
		int tmp = arr[pos];
		arr[pos] = arr[--size];
		arr[size]=0;
		heapify(pos);
		return tmp;
	}
	private void heapify(int pos) {
		int i = pos;
		int l = 2*i+1;
		int r = 2*(i+1);
		while(r<size) {
			if(arr[i]<arr[l] && arr[i]<arr[r])
				return;
			else if(arr[l]<arr[r]) {
				int swap = arr[i];
				arr[i] = arr[l];
				arr[l] = swap;
				i = l;
			}
			else {
				int swap = arr[i];
				arr[i] = arr[r];
				arr[r] = swap;
				i = r;
			}
			l = 2*i+1;
			r = 2*(i+1); 
		}
		if(l<size && arr[i]>arr[l]) {
			int swap = arr[l];
			arr[l] = arr[i];
			arr[i] = swap;
		}
	}
	public int search(int data) {
		int i = 0;
		int l = 2*i+1;
		int r = 2*(i+1);
		while(r<size) {
			if(arr[i]==data) return i;
			else if(arr[l]<arr[r]) 
				i = l;
			else i = r;
			l = 2*i+1;
			r = 2*(i+1); 
		}
		if(l<size && arr[l]==data)
			return l;
		return -1;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void printHeap() {
		if(isEmpty()) return;
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
	}
}
