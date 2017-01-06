package array;

public class SpiralTrav2 {
	public static void main(String[] args) {
		int a[][] = { 
					{1, 2, 3, 4, 5},
		            {6, 7, 8, 9, 10},
		            {11,12,13,14,15},
		            {16,17,18,19,20},
		            {21,22,23,24,25},
		            {26,27,28,29,30}
		    };
		SpiralTrav2 obj=new SpiralTrav2();
		obj.convert(a,6,5);
		System.out.println();
		obj.convertRec(a,5,4,0);
	}
	void convert(int[][] a,int m,int n){
		int r=0,c=0,k=m-1,l=n-1,i,j;
		while(r<=k||c<=l){
			for(i=r,j=c;j<=l;j++)
				System.out.print(a[i][j]+" ");
			r++;
			for(i=r,j=l;i<=k;i++)
				System.out.print(a[i][j]+" ");
			l--;
			for(i=k,j=l;j>=c;j--)
				System.out.print(a[i][j]+" ");
			k--;
			for(i=k,j=c;i>=r;i--)
				System.out.print(a[i][j]+" ");
			c++;
		}
	}
	void convertRec(int[][] a,int m,int n,int k){
		if(m<0||n<0) return;
		int i,j;
		if(n==0){
			for(i=0;i<=m;i++)
				System.out.print(a[i+k][k]+" ");
			return;
		}
		if(m==0){
			for(j=0;j<=n;j++)
			System.out.print(a[k][j+k]+" ");
			return;
		}
		for(j=0;j<=n;j++)
			System.out.print(a[k][j+k]+" ");
		for(i=1;i<=m;i++)
			System.out.print(a[i+k][k+n]+" ");
		for(j=n-1;j>=0;j--)
			System.out.print(a[m+k][j+k]+" ");
		for(i=m-1;i>=1;i--)
			System.out.print(a[i+k][k]+" ");
		convertRec(a,m-2,n-2,k+1);
	}
}
