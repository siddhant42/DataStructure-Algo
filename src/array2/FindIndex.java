package array2;

public class FindIndex {
	public static int findIndex(int[] a) {
		int idx=-1,count=0,maxCount=0,RIdx=-1;
		for(int i=0;i<a.length;i++) {
			if(a[i]==1) count++;
			else {
				count = i-idx;
				idx=i;
			}
			if(maxCount<count) {
				maxCount = count;
				RIdx = idx;
			}
		}
		return RIdx;
	}
	public static void main(String[] args) {
		//int[] a = {1,1,0,0,1,0,1,1,1,0,1,1,1};
		//int[] a = {1,1,0,0,1,1,1};
		//int[] a={1,1,1};
		int[] a = {0,1,1,1,0,0};
		int result = findIndex(a);
		System.out.println(result);
	}
}
