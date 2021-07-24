package array;

public class KthLargest2 {
	public static void main(String[] args) {
		int[] a={3,5,8,15,21,25,26};
		int[] b={4,11,18,19,22};
		new KthLargest2().finLargest(a,b,5);
	}

	private void finLargest(int[] a, int[] b, int k) {
		 findLargest(a,b,0,0,a.length-1,b.length-1,k);
	}

	private void findLargest(int[] a, int[] b, int low1, int low2, int m, int n, int k) {
		if(low1<0||low2<0||low1>m||low2>n||k>(m+n+2)) return;
		int i = (int)((double)(m-low1)/(m+n-low1-low2)*(k-1));
		int j = k-1-i;
		i=m-i;
		j=n-j;
		if(i>=low1 && i<=m && j>=low2 && j<=n){
			int Ai = a[i];
			int Bj = b[j];
			int Ai1 = (i==m)?Integer.MAX_VALUE:a[i+1];
			int Bj1 = (j==n)?Integer.MAX_VALUE:b[j+1];
			if(Ai>Bj && Ai<Bj1){
				System.out.println("kth largest element is "+Ai);
				return;
			}
			else if(Bj>Ai && Bj<Ai1){
				System.out.println("kth largest element is "+Bj);
				return;
			}
			if(Ai>Bj)
				findLargest(a,b,low1,j,i-1,n,k-(m-i+1));
			else
				findLargest(a,b,i,low2,m,j-1,k-(n-j+1));
		}
	}
}
