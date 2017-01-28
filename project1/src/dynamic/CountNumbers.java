package dynamic;
/**
 * A number is non-decreasing if every digit (except the first one)
 *  is greater than or equal to previous digit. For example,
 *   223, 4455567, 899, are non-decreasing numbers.
 *   
 * @author Siddhant Kumar
 *
 */
public class CountNumbers {
	public static void main(String[] args) {
		int n=293;
		long total = new CountNumbers().find(n);
		System.out.println(total);
	}
/*	private long find(int n){
		return find(0,n,0);
	}*/
	// Recursive
	private long find(int st, int n, int idx) {
		long count=0;
		if(idx==n) return 1;
		for(int i=st;i<=9;i++)
			count+=find(i,n,idx+1);
		return count;
	}
	// dynamic
	private long findDyn(int n) {
		long[][] a = new long[n+1][10];
		for(int i=0;i<10;i++)
			a[1][i]=1;
		for(int digit=0;digit<10;digit++) {
			for(int i=2;i<=n;i++) {
				for(int k=0;k<=digit;k++) {
					a[i][digit]+=a[i-1][k];
				}
			}
		}
		long sum=0;
		for(int i=0;i<10;i++)
			sum+=a[n][i];
		return sum;
	}
	// Mathematical
	private long find(int n) {
		if(n>293) return Long.valueOf(0);
		long sum=1;
		int N=10;
		for(int i=0;i<n;i++){
			sum=sum*(N+i)/(i+1);
		}
		return sum;
	}
}
