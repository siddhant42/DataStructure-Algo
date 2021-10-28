package searchNsort;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Find the array of largest element with moving window of size k
 * @author siddhant
 *
 */
public class LargestInKMovingWindow {
	public static int[] find(int[] arr,int k) {
		if(arr==null || arr.length<k) return null;
		int n=arr.length,j=0;
		int[] res = new int[n-k+1];
		Deque<Integer> dq = new LinkedList<>();
		for(int i=0;i<k;i++) {
			while(!dq.isEmpty() && arr[dq.peekFirst()]<=arr[i])
				dq.removeFirst();
			dq.offerFirst(i);
		}
		res[j++] = arr[dq.peekLast()];
		for(int i=k;i<n;i++) {
			while(!dq.isEmpty() && dq.peekLast()<=i-k)
				dq.removeLast();
			while(!dq.isEmpty() && arr[dq.peekFirst()]<=arr[i])
				dq.removeFirst();
			dq.offerFirst(i);
			res[j++] = arr[dq.peekLast()];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr= {10,80,30,90,50,40,46,45};
		int k = 3;
		int[] res = find(arr,k);
		for(int i:res) {
			System.out.print(i+" ");
		}
	}
}
