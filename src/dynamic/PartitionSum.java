package dynamic;

public class PartitionSum {
	static boolean isPart(int[] a) {
		if(a==null||a.length==0||a.length==1) return false;
		int sum=0;
		for(int i=0;i<a.length;i++) sum+=a[i];
		if(sum%2!=0) return false;
		//return findPartRec(a,sum/2,a.length);
		return findPartDyn(a,sum/2,a.length);
	}

	private static boolean findPartRec(int[] a, int sum, int n) {
		if(sum==0) return true;
		if(sum<0 || n<=0) return false;
		if(a[n-1]>sum) return findPartRec(a,sum,n-1);
		else 
			return findPartRec(a,sum-a[n-1],n-1) | findPartRec(a,sum,n-1);
	}
	private static boolean findPartDyn(int[] a,int sum,int n) {
		boolean[][] b = new boolean[sum+1][n+1];
		for(int j=0;j<=n;j++)
			b[0][j] = true;
		for(int i=1;i<=sum;i++) {
			b[i][0] = false;
		}
		for(int i=0;i<=sum;i++) {
			for(int j=1;j<=n;j++) {
			/*if(j==0 ){
					if(i==a[j])
					b[i][j] = true;
					
				}*/
				b[i][j] = b[i][j-1];
				if(a[j-1]<=i) {
					b[i][j] = b[i][j] || b[i-a[j-1]][j-1] ;
				}
			}
		}
		return b[sum][n];
	}
	public static void main(String[] args) {
		int[] a = {1,5,9,5};
		System.out.println(isPart(a));
	}
}
