package array2;

public class MaxSubArray {
	static int find(int[] arr) {
		int idx=-1,resultIdx=-1,sum=0,maxsum=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) sum+=arr[i];
			else {
				sum = i-idx;
				idx = i;
			}
			if(maxsum<sum) {
				maxsum = sum;
				resultIdx = idx;
			}
		}
		return resultIdx;
	}
	public static void main(String[] args) {
	//int arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int arr[] =  {1, 1, 1, 1, 0};
	System.out.println(find(arr));
	}
}
