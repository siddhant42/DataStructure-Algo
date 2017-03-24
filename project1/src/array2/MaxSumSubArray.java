package array2;

public class MaxSumSubArray {
	public static int find(int[] a,int target) {
		int min = Integer.MAX_VALUE,sum=0,sIdx=0,eIdx=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			if(sum>=target) {
			eIdx=i;	
			}
			while(sum>=target) {
				sum-=a[sIdx++];
			}
			int p = eIdx-sIdx+2;
			if(min>p) min = p;
		}
		if(min==Integer.MAX_VALUE) return -1;
		else return min;
	}
	public static void main(String[] args) {
		int[] a = {6,1,2,3,4};
		int target = 6;
		System.out.println(find(a,target));
	}
}
