package dynamic;

public class SubsetSum {
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 10, 2};
		  int sum = 9;
		  boolean b=false;
		  b=new SubsetSum().find(set,sum,set.length-1);
		  System.out.println(b);
	}

	private boolean find(int[] a, int sum, int n) {
		if(sum==0) return true;
		if(n<0) return false;
		return find(a,sum,n-1)||find(a,sum-a[n],n-1);
	}
}
