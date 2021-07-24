package math;

public class Test2 {
	static double findNthRoot(int n,int x) {
		double root = Math.pow(n, 1.0/x);
		return root;
	}
	public static void main(String[] args) {
		int n = 3, x =2;
		int result = (int)findNthRoot(n,x);
		System.out.println(result);
	}
}
