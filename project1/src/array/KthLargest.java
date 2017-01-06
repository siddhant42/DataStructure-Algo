package array;

public class KthLargest {
	public static void main(String[] args) {
		int[] a={3,5,8,15,21,25};
		int[] b={4,11,18,26,28};
		new KthLargest().finLargest(a,b,3);
	}

	private void finLargest(int[] a, int[] b,int k) {
		if((a==null||a.length==0) && (b!=null && k<=b.length)){
			System.out.println(b[b.length-k]);
			return;
		}
		else if((b==null||b.length==0) && (a!=null && k<=a.length)){
			System.out.println(a[a.length]-k);
			return;
		}
		else if(a!=null && k>a.length) return;
		else if(b!=null && k>b.length) return;
		else if(a==null && b==null) return;
		int m=a.length;
		int n=b.length;
		findLargest(a,b,m-k,n-k,m-1,n-1,k);

	}

	private void findLargest(int[] a, int[] b, int i, int j, int m, int n, int k) {
		if(i<=m && j<=n && k>=0){
			if(k==1){
				if(a[m]<b[n]){
					System.out.println(b[n]);
					return;
				}
				else{
					System.out.println(a[m]);
					return;
				}
			}
			int mid1 = (i+m)/2;
			int mid2 = (j+n)/2;
			if(a[mid1]<b[mid2])
				findLargest(a,b,mid1,j,m,mid2,k-(n-mid2));
			else
				findLargest(a,b,i,mid2,mid1,n,k-(m-mid1));
		}

	}
}
