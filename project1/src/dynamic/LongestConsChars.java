package dynamic;

public class LongestConsChars {
	public static void main(String[] args) {
		char ch = 'f';
		char mat[][] = { {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}};
		new LongestConsChars().find(mat,ch);
		System.out.println(maxcount);
	}
	static int count=0,maxcount=0;
	private  void find(char[][] a,char ch) {
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
		if(r==-1 && c==-1) return;
		int[] x={-1,-1,-1,0,0,1,1,1};
		int[] y={-1,0,1,-1,1,-1,0,1};
		findRec(a,r,c,x,y,m,n);
	}
	private void findRec(char[][] a, int r, int c, int[] x, int[] y,int m,int n) {
		count++;
		if(maxcount<count) maxcount=count;
		for(int i=0;i<x.length;i++){
			char ch = a[r][c];
			r+=x[i];
			c+=y[i];
			if(isSafe(a,r,c,ch,m,n)){
				findRec(a,r,c,x,y,m,n);
			}
			r-=x[i];
			c-=y[i];
		}
		
	}
	private boolean isSafe(char[][] a, int r, int c, char ch,int m,int n) {
		if(r>=0 && r<m && c>=0 && c<n && a[r][c]==(ch+1))
			return true;
		return false;
	}
}
