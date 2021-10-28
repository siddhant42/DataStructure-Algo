package classesNobjects;

import java.io.FileNotFoundException;
/**
 * This class demonstrates that if we clone an array of objects
 * then it will not create deep copy of the array elements if
 * the array is declared final 
 * @author siddhant
 *
 */
class A1 implements Cloneable {
	private int a;
	private final Integer[] b;
	private String c;

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

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer[] getB() {
		return b;
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
		obj2.setA(23);
		System.out.println(obj.getA());
		System.out.println(obj2.getA());
		// can't assign as attribute b is final
//		obj2.b = obj.b.clone();
		obj2.getB()[0]=21;
		System.out.println(obj2.getB()[0]);
		System.out.println(obj.getB()[0]);
//		A1 obj2 = new A1(k,p);
//		obj.b[0]=81;
//		System.out.println(obj2.b[0]);

		}
}
