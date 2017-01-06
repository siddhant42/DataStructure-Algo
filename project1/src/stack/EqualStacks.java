package stack;

import java.util.LinkedList;


public class EqualStacks {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.offer(1);
		list.offer(2);
		list.offer(3);
		list.offer(4);
		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.pop());
		System.out.println(list);
		System.out.println(list.element());
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list);
		System.out.println(list.peek());
	}
}
