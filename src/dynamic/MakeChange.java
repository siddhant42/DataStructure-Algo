package dynamic;
/**
 * this class implements for no. of ways an amount
 * of sum can be achieved using given set of 
 * denominations of coins
 * @author Siddhant Kumar
 *
 */
public class MakeChange {
	public static void main(String[] args) {
		MakeChange obj = new MakeChange();
		int n=60;
		int[] s={1,6,5,4};
		int m = s.length;
		System.out.println(obj.findWays3(n,s,m));
		System.out.println(obj.lines);
	}
	int lines = 0;
	// through recursion
	public int findWays(int sum,int[] s,int st) {
		lines++;
		if(sum==0) return 1;
		else if(sum<0 || st>=s.length) return 0;
		int count = 0;
		for(int i=st;i<s.length;i++)
			count+= findWays(sum-s[i],s,i);
		return count;
	}
	// recursive approach2
	public int findWays2(int n,int[] s,int m) {
		lines++;
		if(n==0) return 1;
		else if(n<0 || m<=0) return 0;
		return findWays2(n,s,m-1) + findWays2(n-s[m-1],s,m);
	}
	// dynamic approach
	public int findWays3(int n,int[] s,int m) {
		int[] a = new int[n+1];
		a[0] = 1;
		for(int i=0;i<m;i++) {
			for(int j=s[i];j<=n;j++) {
				a[j] += a[j-s[i]];
				lines++;
			}
		}
		return a[n];
	}
}
