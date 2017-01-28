package dynamic;
/**
 * Given two integers ‘n’ and ‘sum’, find count of all n digit numbers
 *  with sum of digits as ‘sum’. Leading 0’s are not counted as digits.
 *  1 <= n <= 100 and 1 <= sum <= 50000
 *  Example:
 *  Input:  n = 2, sum = 2
 *  Output: 2
 *  Explanation: Numbers are 11 and 20
 *  Input:  n = 2, sum = 5
 *  Output: 5
 *  Explanation: Numbers are 14, 23, 32, 41 and 50
 *  Input:  n = 3, sum = 6
 *  Output: 21
 *  
 * @author Siddhant Kumar
 *
 */
public class CountDigits {
	public static void main(String[] args) {
		int n = 100, sum = 128;
		long count = new CountDigits().find(n,sum);
		System.out.println(count);
	}
	// recursively
	public long find(int n, int sum, int idx) {
		if(sum<0||idx>n||(n*9)<sum) return 0;
		else if(sum==0 && idx==n) return 1;
		long count = 0;
		for(int i=0;i<10&&(i<=sum);i++) {
			if(idx==0 && i==0) continue;
				count+=find(n,sum-i,idx+1);
		}
		return count;
	}
	// dynamically
	private long find(int n, int sum) {
		long[][] a = new long[sum+1][n+1];
		a[0][0]=0;
		for(int i=1;i<=n;i++)
			a[0][i]=1;
		for(int i=0;(i<10)&&(i<=sum);i++)
			a[i][1]=1;
		for(int i=10;i<=sum;i++)
				a[i][1]=0;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				for(int k=0;(k<10)&&(k<=j);k++) {
					if(k==0 && i==n) continue;
					a[j][i] += a[j-k][i-1];
				}
			}
		}
		return a[sum][n];
	}
}
