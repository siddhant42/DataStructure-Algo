package dynamic;

public class MaxSumIncSubSeq {
	public static void main(String[] args) {
		int[] a={1,101,2,3,100,4,5};
		int p = new MaxSumIncSubSeq().find(a,a.length);
		System.out.println(p);
	}

	private int find(int[] a, int n) {
		if(n==1) return a[0];
		int max_ending_here=1;
		for(int i=1;i<n;i++){
			int res=find(a,i);
			if(a[n-1]>=a[i])
				max_ending_here=res+a[i];
		}
		return max_ending_here;
	}
}
