package dynamic;

public class CuttinRod {
/*	static int findMax(int[] a,int[] price,int n) {
		if(n==0) return 0;
		else if(n==1) return price[n-1];
		else if(n==2) 
			return Math.max(2*price[0], price[1]);
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			max = Math.max(max,price[i-1]+ findMax(a,price,n-i));
			//if(max<m) max = m;
		}
		return max;
	}*/
	static int findMax(int[] a,int[] price,int n) {
		int[] s = new int[n+1];
		s[0]=0;s[1]=price[0];
		for(int j=2;j<=n;j++) {
			int max = Integer.MIN_VALUE;
			for(int i=1;i<=j;i++) {
				max = Math.max(max,price[i-1]+s[j-i] );
			}
			s[j] = max;
		}
		return s[n];
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8 };
		int[] price = {1,5,8,9,10,17,17,20};
		System.out.println(findMax(a,price,a.length));
	}
}
