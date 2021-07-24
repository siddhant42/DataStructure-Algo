package dynamic;

import java.util.Arrays;
/**
 * Given a matrix where every cell represents points.
 *  How to collect maximum points using two traversals under following conditions?
 * Let the dimensions of given grid be R x C.
 * 1) The first traversal starts from top left corner, i.e., (0, 0)
 * and should reach left bottom corner, i.e., (R-1, 0). The second 
 * traversal starts from top right corner, i.e., (0, C-1) and should
 * reach bottom right corner, i.e., (R-1, C-1)/
 * 2) From a point (i, j), we can move to (i+1, j+1) or (i+1, j-1) or (i+1, j)
 * 3) A traversal gets all points of a particular cell through which it passes.
 * If one traversal has already collected points of a cell,
 *  then the other traversal gets no points if goes through that cell again.
 *  Input :
 *  int arr[R][C] = {{3, 6, 8, 2},
 *                   {5, 2, 4, 3},
 *                   {1, 1, 20, 10},
 *                   {1, 1, 20, 10},
 *                   {1, 1, 20, 10},
 *                   };
 *  output: 73
 *  
 * @author kumarsid
 *
 */

public class MaxPoints {

	int find(int[][] a){
		if(a==null || a.length==0) return 0;
		int[] cols={-1,0,1};
		int m = a.length,n = a[0].length;
		int[][][] s = new int[m][n][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				Arrays.fill(s[i][j], -1);
		return find(a,s,0,0,n-1,cols,m,n);
	}
boolean isValid(int x,int y1,int y2,int m,int n) {
	if(x>=0&&x<m && y1>=0&&y1<n && y2>=0&&y2<n) 
		return true;
	return false;
}
	private int find(int[][] a,int[][][] s, int x, int y1, int y2, int[] cols, int m, int n) {
		if(!isValid(x,y1,y2,m,n)) return Integer.MIN_VALUE;
		if(x==m-1 && y1==0 && y2==n-1)
			return a[x][y1]+a[x][y2];
		if(x==m-1) return Integer.MIN_VALUE;
		if(s[x][y1][y2]!=-1) return s[x][y1][y2];
		int ans = Integer.MIN_VALUE;
		int tmp = (y1==y2)?a[x][y1]:a[x][y1]+a[x][y2];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
			ans = Math.max(ans, tmp+find(a,s,x+1,y1+cols[i],y2+cols[j],cols,m,n));
			}
		}
		return s[x][y1][y2]=ans;
	}
	public static void main(String[] args) {
		MaxPoints obj = new MaxPoints();
		int arr[][] = {{3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
               };
		System.out.println(obj.find(arr));
	}

}
