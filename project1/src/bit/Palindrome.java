package bit;

public class Palindrome {
	public static boolean isPal(int n) {
		int res=0,p=n;
		while(p>0) {
			res = res<<1;
			res = res| (p&1);
			p = p>>1;
		}
		return n==res;
	}
	public static void main(String[] args) {
		int n = 27;
		System.out.println(isPal(n));
	}
}
