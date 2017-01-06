package backtrack;

public class Sudoku {
	int n=9,row=0,col=0;
	public static void main(String[] args) {
		//Time tm = new Time();
		long st=System.currentTimeMillis();
	int[][] s = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		if(new Sudoku().solution(s)==false)
			System.out.println("solution does't exists");
		long end=System.currentTimeMillis();
		System.out.println("total time in millsec "+(end-st));
		}
	private boolean solution(int[][] s) {
		int r,c;
		if(check(s)==true){
			print(s);
			return true;	
		}
		r=row;c=col;
		for(int i=1;i<=n;i++) {
			
			if(isSafe(s,r,c,i)){
				s[r][c]=i;
				if(solution(s)==true)
					return true;
				else
					s[r][c]=0;
			}
		}
		return false;
	}
	private boolean isSafe(int[][] s, int r, int c, int num) {
		int i,j;
		for(i=0;i<n;i++) {
			if(s[i][c]==num) return false;
		}
		for(j=0;j<n;j++){
			if(s[r][j]==num) return false;
		}
		r=(r/3)*3;
		c=(c/3)*3;
		for(i=r;i<r+3;i++){
			for(j=c;j<c+3;j++){
				if(s[i][j]==num)
					return false;
			}
		}
		return true;
	}
	private void print(int[][] s) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private boolean check(int[][] s) {
		for(row=0;row<n;row++){
			for(col=0;col<n;col++){
				if(s[row][col]==0)
					return false;
			}
		}
		return true;
	}
}
