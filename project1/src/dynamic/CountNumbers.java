package dynamic;

public class CountNumbers {
	public static void main(String[] args) {
		int n=3;
		int total = new CountNumbers().find(0,n,0);
		System.out.println(total);
	}

	private int find(int st, int n, int idx) {
		int count=0;
		if(idx==n) return 1;
		for(int i=st;i<=9;i++)
			count+=find(i,n,idx+1);
		return count;
	}
}
