package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortByFrequency2 {
	public void findCounts(int[] a,int n) {
		System.out.println("For the Array");
		for(int k:a)
			System.out.print(k+" ");
		System.out.println();
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i=0;i<n;i++) {
			if(map.get(a[i])==null)
				map.put(a[i], 1);
			else
				map.put(a[i], map.get(a[i])+1);
		}
		sortByValue(map);
	}
	private void sortByValue(Map<Integer,Integer> map) {
		Set<Map.Entry<Integer,Integer>> set = map.entrySet();
		List<Map.Entry<Integer,Integer>> list = new ArrayList<>(set);
		Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
			@Override
			public int compare(Map.Entry<Integer, Integer> e1,Map.Entry<Integer, Integer> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});
		/*map.clear();
		for(Map.Entry<Integer, Integer> e:list)
			map.put(e.getKey(), e.getValue());
		return map;*/
		for(Map.Entry<Integer, Integer> e:list)
			System.out.println(e.getKey()+" -> "+e.getValue());
	}
	public static void main(String[] args) {
		SortByFrequency2 count = new SortByFrequency2();
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
