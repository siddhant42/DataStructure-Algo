package array2;
public class SubArraySum {
	public int findMin(int[] arr,int target) {
		int minLen=Integer.MAX_VALUE,sIdx=0,end=0,sum=0,n=arr.length;
		while(end<n) {
			while(end<n && sum<target) 
				sum+=arr[end++];
			while(sum>=target) {
				if(minLen>end-sIdx)
					minLen = end-sIdx;
				sum-=arr[sIdx++];
			}
		}
		if(minLen!=Integer.MAX_VALUE) 
			return minLen;
		return -1;
	}
	public int findMin2(int[] arr,int target) {
		int minLen=Integer.MAX_VALUE,sIdx=0,end=0,sum=0,n=arr.length;
		while(end<n) {
			while(end<n && sum<target) { 
				sum+=arr[end++];
				if(sum<0) {
					sIdx=end;
					sum=0;
				}
			}
			while(sum>=target) {
				if(minLen>end-sIdx)
					minLen = end-sIdx;
				sum-=arr[sIdx++];
			}
		}
		if(minLen!=Integer.MAX_VALUE) 
			return minLen;
		return -1;
	}
	public static void main(String[] args) {
		SubArraySum obj = new SubArraySum();
//		int arr[] = {1, 4, 45, 6, 0, 19};
//		int x  =  51;
//		int arr1[] = {1, 10, 5, 2, 7};
//		int x1  = 9;
//		int arr2[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
//		int x2 = 280;
//		int arr3[] = {1, 2, 4};
//		int x3 = 8;
//		int arr4[] = {6,1,2,3};
//		int x4=6;
//		System.out.println(obj.findMin(arr, x));
//		System.out.println(obj.findMin(arr1, x1));
//		System.out.println(obj.findMin(arr2, x2));
//		System.out.println(obj.findMin(arr3, x3));
//		System.out.println(obj.findMin(arr4, x4));
		int arr[] = {- 8, 1, 4, 2, -6,12};
		int target = 8;
		System.out.println(obj.findMin2(arr, target));
	}
}
