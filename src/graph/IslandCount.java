package graph;


public class IslandCount {
	int[] x = {-1,-1,-1,0,0,1,1,1};
	int[] y = {-1,0,1,-1,1,-1,0,1};
	private boolean isSafe(int[][] a,int r,int c,int m,int n) {
		return (r>=0 && r<m && c>=0 && c<n && a[r][c]==1);
	}
	private void countBack(int[][] a,int r,int c,int m,int n,boolean[][] visited) {
		for(int k=0;k<8;k++) {
			r+=x[k];
			c+=y[k];
			if( isSafe(a,r,c,m,n) && !visited[r][c]) {
				visited[r][c] = true;
				countBack(a,r,c,m,n,visited);
			}
			else {
				r-=x[k];
				c-=y[k];
			}
		}
	}
	public int findIslands(int[][] a) {
		int count = 0,m=a.length,n=a[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==1 && !visited[i][j]) {
					countBack(a,i,j,m,n,visited);
					count++;
				}
			}
		}
		return count;		
	}
	public static void main(String[] args) {
		IslandCount obj = new IslandCount();
		int a[][]= {  
				{1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };
		System.out.println(obj.findIslands(a));
	}
	
}
