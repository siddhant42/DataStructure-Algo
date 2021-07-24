package stack;

import java.util.ListIterator;
import java.util.Stack;

public class PrintStack {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
//		for(int i=0;i<s.size();i++)
//			System.out.println(s.elementAt(i));
//		Enumeration<Integer> en = s.elements();
//		while(en.hasMoreElements())
//			System.out.println(en.nextElement());
		ListIterator<Integer> li = s.listIterator();
		while(li.hasNext())
			System.out.println(li.next());
	}
}
