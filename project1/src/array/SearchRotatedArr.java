package array;

public class SearchRotatedArr {
	public int getPivot(int[] a,int low,int high) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(mid==a.length-1 || a[mid]>a[mid+1])
			return mid;
		else if(a[mid]>a[a.length-1])
			return getPivot(a,mid+1,high);
		else
			return getPivot(a,low,mid-1);
	}
	public int binarySearch(int[] a,int key,int low,int high) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(a[mid]==key) return mid;
		else if (key<a[mid])
			return binarySearch(a,key,low,mid-1);
		else
			return binarySearch(a,key,mid+1,high);
	}
	public int binarySearch(int[] a,int key,int low,int high,int n) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(a[mid]==key) return mid;
		else if(a[low]<a[mid]) {
			if(key>=a[low] && key<=a[mid])
				return binarySearch(a,key,low,mid-1,n);
			return binarySearch(a,key,mid+1,high,n);
		}
		if(key>=a[mid+1] && key<=a[high])
			return binarySearch(a,key,mid+1,high,n);
		else
			return binarySearch(a,key,low,mid-1,n);

	}
	public static void main(String[] args) {
		SearchRotatedArr obj = new SearchRotatedArr();
		//		int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		//		int key = 3;
		int[] a = {5, 6, 7, 8, 9, 10,1,3,4};
		int key = 3;
		int n = a.length;
/*		int pivot = obj.getPivot(a, 0, n-1);
		int x = obj.binarySearch(a, key, 0, pivot);
		if(x!=-1)
			System.out.println("found at index "+x);
		else{
			int y = obj.binarySearch(a, key, pivot+1, n-1);
			if(y!=-1)
				System.out.println("found at index "+y);
			else
				System.out.println("not found");
		}*/
		int x = obj.binarySearch(a, key, 0, n-1, n);
		if(x!=-1)
			System.out.println("found at index "+x);
		else
			System.out.println("not found");
	}
}
