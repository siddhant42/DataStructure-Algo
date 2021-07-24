package bitmagic;

public class Sample1 {
public static void main(String[] args) {
	for(int i=2;i<20;i++){
		System.out.print(find(i)+" ");
	}
}
static boolean find( int n){
	return (n&(n-1))==0;
}
}
