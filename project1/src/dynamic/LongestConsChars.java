package dynamic;

import java.util.Arrays;
/**
 * Given a matrix of characters. Find length of the longest path
 *  from a given character, such that all characters in the path
 *  are consecutive to each other, i.e., every character in path
 *  is next to previous in alphabetical order. It is allowed to
 *  move in all 8 directions from a cell.
 *  Example
 *  Input: mat[][] = { {a, c, d},
 *                     {h, b, e},
 *                     {i, g, f}}
 *      Starting Point = 'e'
 *      Output: 5
 *      
 * @author Siddhant Kumar
 *
 */
public class LongestConsChars {
	public static void main(String[] args) {
		char ch = 'f';
		char mat[][] = { {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}};
		int pathCount = new LongestConsChars().find(mat,ch);
		System.out.println(pathCount);
	}
	private  int find(char[][] a,char ch) {
		int r=-1,c=-1;		
		int m = a.length;
		int n = a[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]==ch){
					r=i;c=j;
					break;}
			}
		}
		if(r==-1 && c==-1) return 0;
		int[] rows={-1,-1,-1,0,0,1,1,1};
		int[] cols={-1,0,1,-1,1,-1,0,1};
		//return findMax(a,r,c,rows,cols);
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++)
		Arrays.fill(dp[i], -1);
		return 1+findMax(a,dp,r,c,rows,cols);
	}
	// recursively
	int findMax(char[][] a,int i,int j,int[] rows,int[] cols) {
		if(a==null||a.length==0) return 0;
		int max=1;
		for(int k=0;k<rows.length;k++) {
			int x=i+rows[k];
			int y=j+cols[k];
			if(isSafe(a,i,j,x,y))
			max=Math.max(max, 1+findMax(a,x,y,rows,cols));
		}
		return max;
	}
	boolean isSafe(char[][] a,int i,int j,int x,int y) {
		int m=a.length,n=a[0].length;
		if(x>=0&&x<m && y>=0&&y<n && ((a[i][j]+1)==a[x][y]))
			 return true;
		return false;
	}

	// dynamically
	int findMax(char[][] a,int[][] dp,int i,int j,int[] rows,int[] cols) {
		if(dp[i][j]!=-1) return dp[i][j];
		int ans = 0;
		for(int k=0;k<8;k++) {
			int x=i+rows[k];
			int y=j+cols[k];
			if(isSafe(a,i,j,x,y))
			ans = Math.max(ans, 1+findMax(a,dp,x,y,rows,cols));
		}
		return dp[i][j]=ans;
	}
}
