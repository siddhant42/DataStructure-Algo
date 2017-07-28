package backtrack;

public class MagicSquare {
	public static boolean find(int[][] a,int i,int j,int n,int idx) {
		if(idx==n*n) {
			if(isMagicSquare(a)) return true;
			else return false;
		}
		for(int k=1;k<=n*n;k++) {
			if(isSafe(a,idx,k,n)) {
			a[i][j] = k;
			if(j==n-1){
			if(find(a,i+1,0,n,idx+1)) return true;}
			else if(find(a,i,j+1,n,idx+1)) return true;
			else a[i][j]=0;
			}
		}
		return false;
	}
	private static boolean isSafe(int[][] a,int idx,int num,int n) {
		int count = 0;
		outerLoop:
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++){
					if(a[i][j]==num) return false;
					count++;
					if(count==idx) break outerLoop;
				}
			}
		return true;
	}
	private static boolean isMagicSquare(int[][] a) {
		int n = a.length,sum3=0,sum4=0;
		int totalsum = n*(n*n+1)/2;
		for(int i=0;i<n;i++) {
			int sum1=0,sum2=0;
			for(int j=0;j<n;j++) {
				sum1+=a[i][j];
				sum2+=a[j][i];
				if(i==j) sum3+=a[i][j];
				if(i==n-1-j) sum4+=a[i][j];
			}
			if(sum1!=totalsum || sum2!=totalsum) return false;
		}
		if(sum3!=totalsum || sum4!=totalsum)
		return false;
		return true;
	}
	public static void printArray(int[][] a) {
		if(a==null || a.length==0) return;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 3;
		int[][] a = new int[n][n];
		find(a,0,0,n,0);
		printArray(a);
	}
}
