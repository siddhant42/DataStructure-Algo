package dynamic;

public class MaxNumbers {
	static long find(int n,int st) {
		if(n==0) return 1;
		if(n<0) return 0;
		long max = 0;
		for(int i=st;i<10;i++) {
			max+=find(n-1,i);
		}
		return max;
	}
	public static void main(String[] args) {
		int n=3;
		System.out.println(find(n,0));
	}
}
