package array;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class S1 {
	public static void main(String[] args) {
		int arr[] = {5, 3, -12, 8, 15, -5, 3};
		Map<Integer,Integer> map = new TreeMap<>();
		new S1().find(arr,map);
	}

	private void find(int[] a,Map<Integer,Integer> map) {
		int stidx=0,endidx=0,tmp=0;
		int sum=0,maxdiff=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			if(map.get(sum)!=null){
				stidx=map.get(sum);
				endidx=i;
				System.out.println(stidx+" "+endidx);
				return;
			}
			map.put(sum, i);
		}
		Set<Integer> s =map.keySet();
		for(int i: s) {
			int diff = Math.abs(i-tmp);
			if(maxdiff>diff) {
				if(map.get(tmp)!=null)
					stidx=map.get(tmp);
				endidx=map.get(i);
				maxdiff=diff;
				
			}
			tmp=i;
		}
		System.out.println(stidx+1+" "+endidx);
		

	}
}
