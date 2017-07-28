package matrix;

import java.util.Arrays;

public class LongestPath {
	static int find(int[][] a) {
		int[] x = {-1,1,0,0};
		int[] y={0,0,-1,1};
		int totalmax = 1,n=a.length;
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++)
			Arrays.fill(dp[i], -1);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(dp[i][j]==-1)
				dp[i][j] = find(a,i,j,x,y,n,dp);
				totalmax = Math.max(totalmax,dp[i][j] );
			}
		}
		return totalmax;
	}
	static int find(int[][] a,int r,int c,int[] x,int[] y,int n,int[][] dp) {
		if(r>=n || c>=n) return 0;
				int max = 1;
				for(int k=0;k<4;k++) {
					int row = r+x[k];
					int col = c+y[k];
					if(row<n && row>=0 && col<n && col>=0 && a[r][c]+1==a[row][col]) {
						if(dp[r][c]==-1)
						dp[r][c] = 1+find(a,row,col,x,y,n,dp);
						max = Math.max(max,dp[r][c]);
					}
				}
		return max;
	}
	public static void main(String[] args) {
		int mat[][] = {{1, 2, 9},
        {5, 3, 8},
        {4, 6, 7}};
		int result = find(mat);
		System.out.println(result);
	}
	
}
