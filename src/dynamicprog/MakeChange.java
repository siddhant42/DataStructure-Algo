package dynamicprog;

public class MakeChange {
	public static void main(String[] args) {
		int[] a={5,10,25};
		//int[] a={1,2,3};
		System.out.println(new MakeChange().change(25,a,a.length-1));
		System.out.println(new MakeChange().count(a,a.length,50));
		System.out.println(new MakeChange().makechange(a,0,a.length,50));
	}
	int ways;
	int change(int n,int[] a,int m){
		/*if(m<0||n<0) return 0;
	if(n==0||n==a[0]) return 1;
	 if((m==0)&&(n%a[m]==0)) return 1;
	 if((m<=0)&&(n%a[m]!=0)) return 0;*/

		if(m==0) return 1; 
		for(int i=0;i*a[m]<=n;i++)
			ways=ways+change(n-(a[m]*i),a,m-1);
		return ways;
	}
	int count( int S[], int m, int n ){
		if (n == 0)
			return 1;
		if (n < 0)
			return 0; 
		// If there are no coins and n is greater than 0, then no solution exist
		if (m <=0 && n >= 1)
			return 0; 
		// count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
		return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
	}
/*	int makechange(int[] a,int m,int n){
		int[] s=new int[n+1];
		s[0]=1;
		for(int i=0;i<m;i++){
			for(int j=a[i];j<=n;j++){
				s[j]+=s[j-a[i]];
			}
		}
		return s[n];
	}*/
	int makechange(int[] a,int st,int m,int sum) {
		if(sum==0) return 1;
		else if(sum<0 || st==m) return 0;
		int ways = 0;
		for(int i=0;i*a[st]<=sum;i++) {
			ways += makechange(a,st+1,m,sum-i*a[st]);
			}
		return ways;
	}
}
