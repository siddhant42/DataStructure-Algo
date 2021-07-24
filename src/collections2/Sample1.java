package collections2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sample1 {
public static void main(String[] args) {
	Set<String> list=new HashSet<String>();
	list.add("siddhant");
	list.add("Anil");
	list.add("Saurabh");
	Iterator<String> itr=list.iterator();
	Class c=itr.getClass();
	String name=c.getName();
	System.out.println(name);
}
}
