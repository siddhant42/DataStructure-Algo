package array;
/**
 * Given an unsorted array of n integers which can contain 
 * integers from 1 to n. Some elements can be repeated multiple 
 * times and some other elements can be absent from the array. 
 * Count frequency of all elements that are present and print 
 * the missing elements.
 * Input: arr[] = {2, 3, 3, 2, 5}
 * Output: Below are frequencies of all elements
 *      1 -> 0
 *      2 -> 2
 *      3 -> 2
 *      4 -> 0
 *      5 -> 1
 * @author Siddhant Kumar
 *
 */
public class SortByFrequencies {
	public void findCounts(int[] a,int n) {
		System.out.println("For the Array");
		for(int k:a)
			System.out.print(k+" ");
		System.out.println();
		int i=0,eIdx;
		while(i<n) {
			if(a[i]<=0) {
				i++;
				continue;
			}
			eIdx = a[i]-1;
			if(a[eIdx]>0) {
				a[i]=a[eIdx];
				a[eIdx] = -1;
			}
			else {
				a[i]=0;
				a[eIdx]--;
				i++;
			}
		}


		for(int j=0;j<n;j++)
			System.out.println(j+1+" -> "+Math.abs(a[j]));
	}
	public static void main(String[] args) 
    {
		SortByFrequencies count = new SortByFrequencies();
        int arr[] = {2, 3, 3, 2, 5};
        count.findCounts(arr, arr.length);
 
        int arr1[] = {1};
        count.findCounts(arr1, arr1.length);
 
        int arr3[] = {4, 4, 4, 4};
        count.findCounts(arr3, arr3.length);
 
        int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
        count.findCounts(arr2, arr2.length);
 
        int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        count.findCounts(arr4, arr4.length);
 
        int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        count.findCounts(arr5, arr5.length);
 
        int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        count.findCounts(arr6, arr6.length);
    }
}
