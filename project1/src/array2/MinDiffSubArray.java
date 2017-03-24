package array2;

public class MinDiffSubArray {
	int n,diff = Integer.MAX_VALUE;
	int[] result = new int[n/2];
	void find(int[] a) {
		if(a==null || a.length==0 || a.length==1) return;
		int sum = 0,n = a.length;
		for(int i=0;i<n;i++) {
			sum+=a[i];
		}
			sum/=2;
			int[] s = new int[n/2];
			//int diff = Integer.MAX_VALUE;
			findRec(a,0,0,s,sum);
		
	}
	void findRec(int[] a,int st,int idx,int[] s,int sum) {
		//if(idx>(a.length/2)) return;
		if(idx==a.length/2) {
			if(diff>Math.abs(sum)) {
				diff = Math.abs(sum);
				result = s;
			}
			return;
		}
		for(int i=st;(i<a.length);i++) {
			s[idx] = i;
			findRec(a,i+1,idx+1,s,sum-a[i]);
		}
	}
	public static void main(String[] args) {
		MinDiffSubArray obj = new MinDiffSubArray();
		int[] a = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		//int[] a = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		int len = a.length;
		obj.n = len;
		obj.find(a);
		System.out.println("max diff is "+obj.diff);
//		int[] result2 = new int[len-len/2];
//		int[] result = obj.result;
//		int k=0,j=0;
//		for(int i=0;i<len;i++) {
//			if(i==result[j]) j++;
//			else result2[k++] = i;
//		}
//		System.out.println("first set of elements are ");
//		for(int i:result) System.out.print(result[i]+" ");
//		System.out.println("\n2nd set of elements are ");
//		for(int i:result2) System.out.print(result[i]+" ");
	}
}
