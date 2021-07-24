package dynamic;
/**
 * Given a number x, find sum of digits in all numbers from 1 to n.
 * Examples:
 * Input: n = 5
 * Output: Sum of digits in numbers from 1 to 5 = 15
 * Formula used to calculate n = 10^d-1
 * sum(10^d - 1) = sum(10^d-1 - 1) * 10 + 45*(10^d-1) 
 * 
 * @author Siddhant Kumar
 *
 */
public class CountDigits2 {
	public static void main(String[] args) {
		int n=12;
		System.out.println(find(n));
	}
	static long find(int n){
		if(n<10) return n*(n+1)/2;
		int d = (int)Math.log10(n);
		long[] a = new long[d+1];
		a[0]=0;a[1]=45;
		for(int i=2;i<=d;i++) {
			a[i] = 10*a[i-1] + 45*((long)Math.pow(10, i-1));
		}
		int p = (int)Math.pow(10, d);
		int msd = (int)n/p;
		return (a[d]*msd)+msd*(msd-1)/2 +msd*((n%p)+1)+find(n%p);
	}
}
