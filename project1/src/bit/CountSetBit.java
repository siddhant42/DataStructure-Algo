package bit;

public class CountSetBit {
	public int leftMostBit(int n) {
		int m = 0;
		while(n>1) {
			n = n>>1;
			m++;
		}
		return m;
	}
	int find(int n) {
		if(n==0) return 0;
		int m = leftMostBit(n);
		if(n==Math.pow(2, m+1)-1)
			return (m+1)*(int)Math.pow(2, m);
		n=n-(int)Math.pow(2, m);
		return n+1+m*(int)Math.pow(2, m-1)+find(n);
	}
	public static void main(String[] args) {
		CountSetBit obj = new CountSetBit();
		int n = 6;
		int result = obj.find(n);
		System.out.println(result);
	}
}
