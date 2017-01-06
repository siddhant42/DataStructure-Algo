package dynamic;

public class MakeChange {
	public static void main(String[] args) {
		int n=20;
		int[] s={10,6,5,4};
		System.out.println(new MakeChange().find(n,s,0));
	}

	private int find(int sum, int[] s, int idx) {
		int ways=0;
		
		if(sum<0) return 0;
		if(sum==0) return 1;
		if(idx>=s.length) return 0;
		else{
			for(int i=0;i*s[idx]<=sum;i++)
				ways+=find(sum-i*s[idx],s,idx+1);
		}
		return ways;
	}
}
