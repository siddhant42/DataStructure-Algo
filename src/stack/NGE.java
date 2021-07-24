package stack;

import java.util.Stack;
/**
 * Given an array, print the Next Greater Element (NGE)
 * for every element. The Next greater Element for an element x 
 * is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider 
 * next greater element as -1
 * 
 * @author Siddhant Kumar
 *
 */
public class NGE {
	// convert the given array into array of next greater
	// elements and return it.
	public static int[] generateNGE(int[] a) {
		if(a==null || a.length==0)
			return a;
		int tmp=-1,n=a.length;
		Stack<Integer> st = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			while(!st.empty() && a[i]>=st.peek())
				st.pop();
			if(st.empty()) tmp = -1;
			else tmp = st.peek();
			st.push(a[i]);
			a[i] = tmp;
		}
		return a;
	}
	// to print the array
	public static void print(int[] a) {
		if(a==null||a.length==0) return;
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args) {
		int[] a = {4,5,2,25};
		int[] a2 = {13,7,6,12};
		generateNGE(a);
		print(a);
		System.out.println();
		generateNGE(a2);
		print(a2);
	}
}
