package dynamic;

public class MinSquares {
	public static void main(String[] args) {
		int n=100;
		System.out.println(new MinSquares().findMin(n));
	}

	private int findMin(int n) {
		int count =0;
		while(n>0) {
			count++;
			int s = (int)Math.sqrt(n);
			n-=Math.pow(s, 2);
		}
		return count;
	}
}
