package string;

public class Reverse {
	public static String reverse1(String s){
		if(s==null||s.length()==0)
			return s;
		return new StringBuilder(s).reverse().toString();
	}
public static void main(String[] args) {
	String s1=new String("Hello World");
	String s2= reverse1(s1);
	System.out.println(s2);
}
}
