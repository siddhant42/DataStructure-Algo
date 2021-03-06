package dynamic2;

public class RodCut {
	public int find(int n) {
		if(n==1||n==0) return 0;
		int maxsum = 0;
		for(int i=1;i<=Math.sqrt(n)+1;i++) {
			int max = Math.max(i*find(n-i), i*(n-i));
			if(maxsum<max) maxsum  = max;
		}
		return maxsum;
	}
	int findMax(int n) {
		int[] s = new int[n+1];
		for(int i=2;i<=n;i++){
			for(int j=1;j<=Math.sqrt(i)+1;j++)
			s[i]=Math.max(s[i], Math.max(j*(i-j),j*s[i-j]));
		}
		return s[n];
	}
	int maxProd(int n){
		if(n==1||n==0) return 0;
		else if(n==3||n==2) return n-1;
		int res=1;
		while(n>4){
			n-=3;
			res*=3;
		}
		return n*res;
	}
	public static void main(String[] args) {
		int n = 25;
		int sum = new RodCut().maxProd(n);
		System.out.println(sum);
	}
}
