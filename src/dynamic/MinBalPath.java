package dynamic;

public class MinBalPath {
	int findMin(int[][] a,int m,int n) {
		int[][] s = new int[m][n];
		s[m-1][n-1]=-1*a[m-1][n-1]+1;
		for(int i=m-2;i>=0;i--) {
			s[i][n-1] = Math.max(1, s[i+1][n-1]-a[i][n-1]);
		}
		for(int j=n-2;j>=0;j--) {
			s[m-1][j] = Math.max(1, s[m-1][j+1]-a[m-1][j]);
		}
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				s[i][j]=Math.max(1, Math.min(s[i+1][j], s[i][j+1])-a[i][j]);
			}
		}
		return s[0][0];
	}
	public static void main(String[] args) {
		int m=3,n=3;
		int[][] a={{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
		};
		System.out.println(new MinBalPath().findMin(a, m, n));
	}
}
