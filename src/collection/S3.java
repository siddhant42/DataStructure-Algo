package collection;

import java.util.LinkedList;

public class S3 {
public static void main(String[] args) {
	LinkedList<Integer> list = new LinkedList<>();
	list.add(4);
	list.add(6);
	list.add(1);
	list.addFirst(3);
	list.remove(new Integer(8));
	System.out.println(list);
}
}
