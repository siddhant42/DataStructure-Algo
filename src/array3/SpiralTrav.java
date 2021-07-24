package array3;
public class SpiralTrav {
	void convertrec(int a[][],int m,int n,int k){
		int i,j;
		if(m<=0||n<=0) return;
		if(m==1){
			for(j=0;j<n;j++)
				System.out.print(a[k][k+j]+" ");
				return;
			
		}
		if(n==1){
			for(i=0;i<m;i++)
				System.out.print(a[k+i][k]+" ");
				return;
			
		}
		for(j=0;j<n;j++){
			System.out.print(a[k][k+j]+" ");
		}
		for(i=1;i<m;i++){
			System.out.print(a[k+i][k+n-1]+" ");
		}
		for(j=n-2;j>=0;j--){
			System.out.print(a[k+m-1][k+j]+" ");
	}
	for(i=m-2;i>0;i--){
		System.out.print(a[k+i][k]+" ");
	}
	convertrec(a,m-2,n-2,k+1);
	}
	void convert(int a[][],int m,int n){
		convertrec(a,m,n,0);
	}
public static void main(String[] args) {
	int a[][] = { 
				{1, 2, 3, 4, 5},
	            {6, 7, 8, 9, 10},
	            {11,12,13,14,15},
	            {16,17,18,19,20},
	            {21,22,23,24,25}
	    };
	new SpiralTrav().convert(a,5,5);
}
}

