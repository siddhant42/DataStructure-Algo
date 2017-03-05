package stack;

import java.util.Stack;

public class StackReverse {
	public static void reverse(Stack<Integer> st) {
		if(st.empty()) return;
		int tmp = st.pop();
		reverse(st);
		insertAtBottom(st,tmp);
	}
	private static void insertAtBottom(Stack<Integer> st,int data) {
		if(st.empty()) {
			st.push(data);
			return;
		}
		int tmp = st.pop();
		insertAtBottom(st,data);
		st.push(tmp);
	}
	public static void printFromBottom(Stack<Integer> st) {
		if(st.empty()) return;
		int tmp = st.pop();
		printFromBottom(st);
		System.out.print(tmp+" ");
		st.push(tmp);
	}
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println("Before reverse printing from bottom");
		printFromBottom(st);
		reverse(st);
		System.out.println("\nAfter reverse printing from bottom");
		printFromBottom(st);
	}
}
