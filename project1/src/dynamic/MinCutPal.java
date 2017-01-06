package dynamic;

public class MinCutPal {
	static int findMin(char[] s,int st,int n){
		int min = findMinRec(s,st,n);
		return min-1;
	}
	static int findMinRec(char[] s,int st,int n) {
		if(st>n || n<0 ) return 0;
		if(st==n) return 1;
		if(isPal(s,st,n)) return 1;
		int min = Integer.MAX_VALUE;
		for(int i=st;i<n;i++)
		min = Math.min(min,findMinRec(s,st,i)+findMinRec(s,i+1,n));
		return min;
	}
	static boolean isPal(char[] s,int i,int n) {
		if(s==null||s.length==0) return true;
		int j=n;
		while(i<j) {
			if(s[i]!=s[j]) return false;
			i++;j--;
		}
		return true;
	}
/*	static int findMinDyn(char[] s,int n) {
		if(s==null || s.length==0 || s.length==1) return 0;
		boolean[][] b = new boolean[n+1][n+1];
		int[][] a = new int[n+1][n+1];
		for(int i=n;i>=0;i--) {
			for(int j=i;j<=n;j++) {
				if(i==j) b[i][j] = true;
				else if(i==j-1) b[i][j] = (s[i]==s[j]);
				else b[i][j] = (s[i]==s[j] && b[i+1][j-1]);
				if(i==j) a[i][j]=1;
				else if(b[i][j]) a[i][j]=1;
				else {
					int min = Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {
						int m = a[i][k]+a[k+1][j];
						if(min>m) min = m;
					}
					a[i][j] = min;
				}
			}
		}
		return a[0][n]-1;
	}*/
	static int findMinDyn(char[] s,int n) {
		int[] a = new int[n+1];
		boolean[][] p = new boolean[n+1][n+1];
		for(int i=n;i>=0;i--) {
			for(int j=i;j<=n;j++) {
				if(i==j) p[i][j] = true;
				else if(i==j-1) p[i][j] = (s[i]==s[j]);
				else p[i][j] = (s[i]==s[j] && p[i+1][j-1]);
			}
		}
		for(int i=0;i<=n;i++) {
			if(p[0][i]) a[i] = 0;
			else {
				a[i] = Integer.MAX_VALUE;
				for(int j=0;j<i;j++) {
					if(p[j+1][i] && a[i]>a[j]+1)
						a[i] = a[j]+1;
				}
			}
 		}
		return a[n];
	}
	public static void main(String[] args) {
		//char[] ch = "ababbbabbababa".toCharArray();
		char[] ch = "aabbca".toCharArray();
		System.out.println(findMinDyn(ch,ch.length-1));
		//System.out.println(findMin(ch,0,ch.length-1));
	}
}
