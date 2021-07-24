package array2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Test1 {
	public void m1(HashMap str) {
		System.out.println("in string method");
	}
	public void m1(LinkedHashMap str) {
		Objects.requireNonNull(str);
		System.out.println("in object method");
	}
	
	public static void main(String[] args) throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
//		System.out.println(list.poll());
//		System.out.println(list.peek());
		//System.out.println(list.getFirst());
//		list.push(1);
//		list.push(2);
//		list.push(3);
		System.out.println(list.pop());
		System.out.println(list.peek());
	}
}