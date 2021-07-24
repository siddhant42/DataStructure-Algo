package other;

public class Sample1 {
	protected Sample1(){
		System.out.println("p");
	}
	void m(){
		System.out.println("this is method m");
	}
public static void main(String[] args) {
	try {
		Sample1 obj = (Sample1) Class.forName("other.Sample1").newInstance();
		obj.m();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	// A new way of creating object with calling new keyword and constructor call
	
}
}
