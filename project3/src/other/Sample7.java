package other;

public class Sample7 {
private class Base{
	private int a=3;
}
class Drv extends Abc{
	
}
public static void main(String[] args) {
	Sample7 s=new Sample7();
	//System.out.println(s.a);
	Base b=s.new Base();
	System.out.println(b.a);
}
}
class Abc{
	public void m1(){}
}