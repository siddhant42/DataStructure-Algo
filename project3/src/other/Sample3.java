package other;

public class Sample3 {
	int a;
	void m(Sample3 s1){
		s1.a=7;
	}
public static void main(String[] args) {
	
	Sample3 s=new Sample3();
	Sample3 s2=new Sample3();
	s.a=5;
	s2.m(s);
	System.out.println(s.a);
	
}

}
