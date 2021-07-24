package string;

public class InternMethod {
public static void main(String[] args) {
	String s1="Hello";
	String s2=new String("Hello");
	String s3=s2.intern();
	System.out.println(s1==s2);
	System.out.println(s2==s3);
	System.out.println(s1==s3);
}
}
