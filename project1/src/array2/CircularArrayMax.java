package array2;

public class CircularArrayMax {
	public static void find(int[] a) {
		int maxsum1 = findMax(a);
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			a[i]=-a[i];
		}
		int maxsum2 = sum+findMax(a);
		System.out.println(Math.max(maxsum1, maxsum2));
	}
	public static int findMax(int[] a) {
		int sum=a[0],maxsum=a[0];
		for(int i=1;i<a.length;i++) {
			sum+=a[i];
			if(sum<a[i]) sum = a[i];
			if(maxsum<sum) maxsum = sum;
		}
		return maxsum;
	}
	public static void main(String[] args) {
		int[] a1 = {8, -8, 9, -9, 10, -11, 12};
		int[] a2 = {10, -3, -4, 7, 6, 5, -4, -1};
		int[] a3 = {-1, 40, -14, 7, 6, 5, -4, -1};
		int[] a4 = {3,56,2};
		find(a1);
		find(a2);
		find(a3);
		find(a4);
	}
}
/*public static void findMax(int[] a) {
	if(a==null || a.length==0) 
		return;
	int n = a.length;
	int stIdx=-1,eIdx=-1,sum=0,minsum=0,s=-1;
	for(int i=0;i<n;i++) {
		if(a[i]<0) {
			sum+=a[i];
			if(sum>=a[i]) {
				sum = a[i];
				s = i;
			}
		}
		else sum = 0;
		if(minsum>sum) {
			minsum = sum;
			stIdx = s;
			eIdx = i;
		}
	}
	int start = (eIdx==n-1 || stIdx==-1)?0:eIdx+1;
	int end = (stIdx==0 || eIdx==-1)?n-1:stIdx-1;
	sum = a[start];
	int maxsum = a[start];
	int i = start+1;
	for(;i<n;i++) {
		sum+=a[i];
		if(sum<a[i]) sum = a[i];
		if(maxsum<sum) maxsum = sum;
	}
	if(end!=n-1) i = 0;
	for(;i<=end;i++) {
		sum+=a[i];
		if(sum<a[i]) sum = a[i];
		if(maxsum<sum) maxsum = sum;
	}
	System.out.println("minsum= "+minsum+" maxsum= "+maxsum);
}*/