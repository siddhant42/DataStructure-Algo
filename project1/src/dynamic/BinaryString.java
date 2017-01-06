package dynamic;

public class BinaryString {
	static int findMax(int n,int k) {
		if(n<=0) return 0;
		if(n==1 && k==0) return 2;
		else if(n==1 && k==1) return 1;
		else if(k==0)
			return findMax(n-1,0)+findMax(n-1,1);
		else
			return findMax(n-1,0);
	}
	static int findMax(int n) {
		if(n<=0) return 0;
		int a=1,b=1;
		for(int i=1;i<=n;i++){
			int c = a+b;
			b=a;
			a=c;
		}
		return a;
	}
	public static void main(String[] args) {
		int n=6;
		System.out.println(findMax(n,0));
		System.out.println(findMax(n));
	}
}
