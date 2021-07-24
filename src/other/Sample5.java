package other;

public class Sample5 {
void m(Object obj){
	System.out.println("obj");
	System.out.println(obj);
}
/*void m(Sample5 s){
	System.out.println("class");
	System.out.println(s);
}*/
/*void m(String str){
	System.out.println("string");
	System.out.println(str);
}*/
void m(Integer i){
	System.out.println("integer");
	System.out.println(i);
}
public static void main(String[] args) {
	new Sample5().m(null);
}
}
