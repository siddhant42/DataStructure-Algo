package bit;

public class NextNum {
	public static int find(int n) {
		if(n==0) return 0;
		int c1 = 1;
		while((n&c1)==0) c1 = c1<<1;
		int c2 = c1<<1;
		if((n&c2)!=0) {
			while((n&c2)!=0) c2= c2<<1;
			n = n^c2;
			c2 = c2>>1;
			n = n^1;
		}
		n = n^c2;
		n = n^c1;
		return n;
	}
	public static void main(String[] args) {
		int n = 12;
		int result = find(n);
		System.out.println(result);
		
	}
}
