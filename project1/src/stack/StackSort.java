package stack;

import java.util.Stack;

public class StackSort {
	public static void sort(Stack<Integer> st) {
		if(st.empty()) return;
		int tmp = st.pop();
		sort(st);
		sort(st,tmp);
	}
	private static void sort(Stack<Integer> st,int data) {
		if(st.empty() || data<st.peek()) {
			st.push(data);
			return;
		}
		int tmp = st.pop();
		sort(st,data);
		st.push(tmp);
	}
	public static void printFromTop(Stack<Integer> st) {
		if(st.empty()) return;
		int tmp = st.pop();
		System.out.print(tmp+" ");
		printFromTop(st);
		st.push(tmp);
	}
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(15);
		st.push(2);
		st.push(10);
		st.push(11);
		st.push(6);
		st.push(25);
		System.out.println("printing unsorted stack from top ");
		printFromTop(st);
		sort(st);
		System.out.println("\nprinting sorted array from top");
		printFromTop(st);
	}
}
