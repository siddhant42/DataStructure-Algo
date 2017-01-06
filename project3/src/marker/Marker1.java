package marker;

public class Marker1 implements Cloneable{
	int a;
	String s;
	
public Marker1() {
		System.out.println("p");
	}
public Marker1(int a, String s) {
		super();
		this.a = a;
		this.s = s;
	}
protected Object clone() throws CloneNotSupportedException{
	return super.clone();
}

void m(){
	System.out.println("this is method m");
}
@Override
public String toString() {
	return "Marker1 [a=" + a + ", s=" + s + "]";
}
public static void main(String[] args) {
	Marker1 m3=new Marker1();
	
	try {
	Marker1	m4 = (Marker1)m3.clone();   // A new way of creating object without calling new keyword and constructor call
	m4.m();
	System.out.println(m3==m4);
	System.out.println(m3.equals(m4));
	} catch (CloneNotSupportedException e) {
		e.printStackTrace();
	}
	
}
}
