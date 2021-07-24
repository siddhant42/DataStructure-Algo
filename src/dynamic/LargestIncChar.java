package dynamic;

public class LargestIncChar {
	static int findMax(char[][] a,int i,int j,int m,int n,char st) {
		int[] row={-1,-1,-1,0,0,1,1,1};
		int[] col={-1,0,1,-1,1,-1,0,1};
		return findMax(a,i,j,m,n,st,row,col);
	}

	private static int findMax(char[][] a, int i, int j, int m, int n, char st, int[] row, int[] col) {
		if(a[i][j]!=st) return 0;
		int max = Integer.MIN_VALUE;
		for(int k=0;k<row.length;k++) {
			i+=row[k];
			j+=col[k];
			if(i<m&&j<n&&i>=0&&j>=0) {
				max=Math.max(max, 1+findMax(a,i,j,m,n,(char)(st+1),row,col));
			}
				i-=row[k];
				j-=col[k];
		}
		return max;
	}
	public static void main(String[] args) {
		char[][] a = { {'a','c','f'},
				{'h','b','e'},
				{'i','g','f'}
		};
		System.out.println(findMax(a,1,2,3,3,'e'));
	}
}
