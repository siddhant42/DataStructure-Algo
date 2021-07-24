package stack;

import java.util.Stack;
/**
 * Given an expression string exp , write a program 
 * to examine whether the pairs and the orders of 
 * “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. 
 * For example, the program should print true for 
 * exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 * 
 * @author Siddhant Kumar
 *
 */
public class BalancedPar {
	// check balance for string of paranthesis
	public static boolean check(char[] a) {
		if(a==null || a.length==0) 
			return true;
		Stack<Character> st = new Stack<>();
		for(int i=0;i<a.length;i++) {
			if(!st.empty() && (a[i]=='}' || a[i] == ']' || a[i]==')')
					&& checkPair(a[i],st.peek()))
				st.pop();
			else
				st.push(a[i]);
		}
		return st.empty();
	}
	// check if two two characters are balanced parenthesis
	private static boolean checkPair(char a,char b) {
		if(a=='}' && b == '{')
			return true;
		else if (a==']' && b=='[')
			return true;
		else if (a==')' && b == '(')
			return true;
		return false;
	}
	public static void main(String[] args) {
		String str = "[()]{}{[()()]()}"; // true
		String str2 = "[(])"; // false
		String str3 = "){}("; // false
		String str4 = ")"; // false
		System.out.println(check(str.toCharArray()));
		System.out.println(check(str2.toCharArray()));
		System.out.println(check(str3.toCharArray()));
		System.out.println(check(str4.toCharArray()));
	}
}
