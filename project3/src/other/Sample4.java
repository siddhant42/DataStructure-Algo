package other;

public class Sample4 {
static void m(int n){
	System.out.println("method m prints "+n);
}
static void m(char c){
	System.out.println("method m prints "+c);
}
public static void main(String[] args) {
	//Sample4 s=new Sample4();
	m('a');
	m(5);
}
}
