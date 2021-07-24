package bitmagic;

public class Reverse1 {
void reverse(int n){
	if(n==0) return;
	System.out.print(n%2);
	reverse(n/2);
	
}
int reverse2(int n){
	int a=(n & 0x0f)<<4;
	int b=(n & 0xf0)>>4;
	return (a|b);
}
public static void main(String[] args) {
	int n=182;
	Reverse1 obj=new Reverse1();
	obj.reverse(n);
	System.out.println();
	System.out.println(obj.reverse2(n));
	
}
}
