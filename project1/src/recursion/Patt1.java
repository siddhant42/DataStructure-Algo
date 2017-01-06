package recursion;

public class Patt1 {
	public static void main(String[] args) {
		int n=15,k=5;
		new Patt1().find(n,k);
	}

	private void find(int n, int k) {
		System.out.print(n+" ");
		if(n<=0) return;
		find(n-k,k);
		System.out.print(n+" ");
	}
}
