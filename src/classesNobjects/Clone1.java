package classesNobjects;

import java.io.FileNotFoundException;

class A1 implements Cloneable {
	int a;
	final Integer[] b;
	String c;

	public A1(int a, Integer[] b) {
		super();
		this.a = a;
		this.b = b;
	}
	
//	public A1(int a, String c) {
//		super();
//		this.a = a;
//		this.c = c;
//	}

	@Override
	protected A1 clone() throws CloneNotSupportedException {
		return (A1)super.clone();
	}
	void m1() throws FileNotFoundException {
		System.out.println("inside m1");
	}
}
public class Clone1 {
	public static void main(String[] args) throws Exception {
		Integer[] p = {3,6,9,12};
		Integer[] x = {1,3,7,4};
		String s = "abc";
		int k = 234;
		A1 obj = new A1(k,p);
		A1 obj2 = obj.clone();
//		obj2.b = obj.b.clone();
		obj2.b[0]=21;
		System.out.println(obj2.b[0]);
		System.out.println(obj.b[0]);
//		A1 obj2 = new A1(k,p);
//		obj.b[0]=81;
//		System.out.println(obj2.b[0]);

		}
}
