package other;


public class Sample8 {
	static int a=9;
	int b=8;
	Sample8(){
		this(4);
	}
	void m2(){
		System.out.println(a);
		System.out.println(b);
		System.out.println("method m2");
	}
static void m1(){
	System.out.println(a);
	//System.out.println(b);
	new Sample8().m2();
}
public Sample8(long b){
	System.out.println(b);
}
public static void main(String[] args) {
	Sample8 s=new Sample8();
}
}
