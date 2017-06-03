package collection;

import java.util.WeakHashMap;

public class WeakHMExample {
	public static void main(String[] args) {
		WeakHashMap<A32,Integer> whm = new WeakHashMap<>();
		A32 obj = new A32();
		whm.put(obj, 12);
		System.out.println(whm);
		obj = null;
		System.gc();
		System.out.println(whm);
	}
}
class A32 {
	public String toString(){
		return "Test";
	}
}