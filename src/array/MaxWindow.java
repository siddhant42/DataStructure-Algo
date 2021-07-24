package array;

import java.util.LinkedList;

public class MaxWindow {
	public static void main(String[] args) {
		int[] a={12, 1, 78, 90, 57, 89, 56};
		int k=3;
		new MaxWindow().printMax(a,k);
	}

	private void printMax(int[] a, int k) {
		LinkedList<Integer> deq = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			while(deq.isEmpty()==false && a[deq.peekFirst()]<=a[i])
				deq.removeFirst();
			deq.addFirst(i);
		}
		for(int i=k;i<a.length;i++){
			System.out.print(a[deq.peekLast()]+" ");
			while(deq.isEmpty()==false && deq.peekLast()<=i-k)
				deq.removeLast();
			while(deq.isEmpty()==false && a[deq.peekFirst()]<=a[i])
				deq.removeFirst();
			deq.addFirst(i);
		}
		System.out.println(a[deq.peekLast()]);
	}
}
