package dynamic;

public class S1 {
	public static void main(String[] args) {
		int[] a={1,3,0,8,9,2,6,7,6,8,9};
		System.out.println(new S1().find(a,0,0));
	}
//int min = Integer.MAX_VALUE;
	private int find(int[] a, int idx, int count) {
		int min = Integer.MAX_VALUE;
		if(idx==a.length)
			return count;
		if(a[idx]==0)
			return Integer.MAX_VALUE;
		for(int i=idx;(i<a.length && i<idx+a[idx]);i++) {
			int curr_min= find(a,i+1,count+1);
			if(min>curr_min)
				min = curr_min;
		}
		return min;
	}
}
