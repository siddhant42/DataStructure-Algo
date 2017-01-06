package array;

public class KthSmallest {
	public static void main(String[] args) {
		int[] a={3,5,8,15,21,25};
		int[] b={4,11,18,26,28};
		new KthSmallest().findSmallest(a,b,3);
	}

	private void findSmallest(int[] a, int[] b, int k) {
		 findSmallest(a,b,0,0,a.length-1,b.length-1,k);
	}

	private void findSmallest(int[] a, int[] b, int low1, int low2, int m, int n, int k) {
		if(low1<0||low2<0||low1>m||low2>n||k>(m+n+2)) return;
		int i = (int)((double)(m-low1)/(m+n-low1-low2)*(k-1));
		int j = k-1-i;
		if(i>=low1 && i<=m && j>=low2 && j<=n){
			int Ai_1 = (i==0)?Integer.MIN_VALUE:a[i-1];
			int Bj_1 = (j==0)?Integer.MIN_VALUE:b[j-1];
			int Ai = a[i];
			int Bj = b[j];
			if(Ai<Bj && Ai>Bj_1){
				System.out.println("kth smallest element is "+Ai);
				return;
			}
			else if(Bj<Ai && Bj>Ai_1){
				System.out.println("kth smallest element is "+Bj);
				return;
			}
			if(Ai<Bj)
				findSmallest(a,b,low1+i+1,low2,m,j,k-i-1);
			else
				findSmallest(a,b,low1,low2-j-1,i,n,k-j-1);
		}
	}
}
