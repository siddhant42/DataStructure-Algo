package array2;

public class MaxTriangle {
	public int find(int[] a) {
		int[] s = new int[3];
		return findMax(a,s,0,0,a.length);
	}
	private int findMax(int[] a,int[] s,int st,int idx,int n) {
		if(idx==3) {
			if(isTriangle(s)) return 1;
			else return 0;
		}
		else if(st>=n) return 0;
		int count=0;
		for(int i=st;i<n;i++) {
			s[idx] = a[i];
			count+=findMax(a,s,i+1,idx+1,n);
		}
		return count;
	}
	boolean isTriangle(int[] s) {
		if(s.length!=3) return false;
		int max = Math.max(s[0], Math.max(s[1], s[2]));
		int sum = s[0]+s[1]+s[2];
		return (2*max-sum<0);
	}
	public static void main(String[] args) {
		MaxTriangle obj = new MaxTriangle();
		int[] a =  {4, 6, 3, 7};
		System.out.println(obj.find(a));
	}
}
