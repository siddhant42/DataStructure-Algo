package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S2 {
	public static void main(String[] args) {
		Integer[] a={5,7,1,9,2,4,3};
		List<Integer> list = Arrays.asList(a);
		Collections.sort(list,Collections.reverseOrder());
		for(int i:list)
			System.out.print(i+" ");
	}
}
