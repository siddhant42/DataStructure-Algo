package searchNsort;

public class KthSmallest {
	static int find(int[] arr,int k) {
		return qselect(arr,0,arr.length-1,k);
	}
	static int qselect(int[] arr,int low,int high,int k) {
		if(k>=arr.length) return -1;
		if(low>high) return -1;
		if(low==high) return arr[low];
		int rand = low+(int) (Math.random()*(high-low+1));
		int pivot = arr[rand];
		int lb=low,ub=high;
		while(lb<ub) {
			while(arr[lb]<=pivot && lb<high) lb++;
			while(arr[ub]>=pivot && ub>low) ub--;
			if(lb<ub) {
				int tmp = arr[lb];
				arr[lb] = arr[ub];
				arr[ub] = tmp;
			}
		}
		if(lb<rand && arr[lb]>pivot) ub = lb;
		int tmp = arr[rand];
		arr[rand] = arr[ub];
		arr[ub] = tmp;
		if(ub==k-1) return pivot;
		else if(ub>k-1)
			return qselect(arr,low,ub-1,k);
		else
			return qselect(arr,ub+1,high,k);
	}
	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 3, 20, 15};
	     int  k = 3;
	     System.out.println(find(arr,k));
	}
}
