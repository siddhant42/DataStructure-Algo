package other;
import static java.lang.System.*;
public class VarArgsExample {
	static void m(int n,String... abc){
		out.println(n);
		for(String s:abc)
			out.print(s+" ");
	}
public static void main(String[] args) {
	m(5,"this","is","siddhant");
}
}
