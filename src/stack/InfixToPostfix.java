package stack;

import java.util.Stack;
/**
 * This class is designed to support converting of infix expression
 * into postfix expression
 * @author Siddhant Kumar
 *
 */
public class InfixToPostfix {
	// return precedence of a character passed
	private static int preced(char ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		
		}
		return -1;
	}
	// convert the given array from infix to postfix and return
	private static char[] convert(char[] a) {
		if(a==null || a.length==0 || a.length==1)
			return a;
		Stack<Character> st = new Stack<>();
		int k=0;
		for(int i=0;i<a.length;i++) {
			if(preced(a[i]) == -1)
				a[k++]=a[i];
			else {
				while(!st.empty() && (preced(a[i])<=preced(st.peek())))
						a[k++] = st.pop();
				st.push(a[i]);
			}
		}
		while(!st.empty())
			a[k++]=st.pop();
		return a;
	}
	public static void main(String[] args) {
		String str = "a+b*c-d";
		char[] c = convert(str.toCharArray());
		System.out.println(String.valueOf(c));
	}
}
