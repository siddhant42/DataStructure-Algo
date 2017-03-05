package array;
/**
 * Inversion Count for an array indicates – how far (or close) 
 * the array is from being sorted. If array is already sorted 
 * then inversion count is 0. If array is sorted in reverse 
 * order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an 
 * inversion if a[i] > a[j] and i < j
 * Example:
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 * 
 * @author Siddhant Kumar
 *
 */
public class InversionCount {
	public int mergerSort(int[] a) {
		return mergeSort(a,0,a.length-1);
	}
	private int mergeSort(int[] a,int low,int high) {
		if(low>=high) return 0;
		int mid = (low+high)/2;
		int count = mergeSort(a,low,mid);
		count+=mergeSort(a,mid+1,high);
		count+=merge(a,low,mid,high);
		return count;
	}
	private int merge(int[] a,int low,int mid,int high) {
		if(low>=high) return 0;
		int i=low,j=mid+1,k=0,count=0;
		int[] tmp = new int[high-low+1];
		while(i<=mid && j<=high) {
			if(a[i]<a[j]) {
				tmp[k++]=a[i++];
			}
			else {
				count += (mid-i+1);
				tmp[k++]=a[j++];
			}
		}
		while(i<=mid)
			tmp[k++]=a[i++];
		while(j<=high)
			tmp[k++]=a[j++];
		k=0;
		for(i=low;i<=high;i++)
			a[i]=tmp[k++];
		return count;
	}
	public static void main(String[] args) {
		InversionCount obj = new InversionCount();
		int[] arr = {1, 20, 6, 4, 5};
		System.out.println(obj.mergerSort(arr));
	}
}
