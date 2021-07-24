package other;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class MaxWindow {
public static void main(String[] args) {
	int[] a={6,12,4,3,10,2,1};
	new MaxWindow().find(a,3);
}
void find(int[] a,int w){
	int i;
	//Map<Integer,Integer> m=new HashMap<Integer,Integer>();
	//ValueComparator obj=new ValueComparator();
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	for(i=0;i<w-1;i++)
		map.put(i, a[i]);
	TreeMap<Integer,Integer> tm=null;
	for(i=w-1;i<a.length;i++){
		map.put(i, a[i]);
		ValueComparator obj=new ValueComparator(map);
  tm=new TreeMap<Integer,Integer>(obj);
  tm.putAll(map);
 /* Set<Integer> s=tm.keySet();
  for(Integer in:s)
	  System.out.print(tm.get(in)+" ");
  System.out.println();*/
 System.out.print(tm.get(tm.lastKey())+" ");
		map.remove(i-w+1);
		
	}
	
}

}
class ValueComparator implements Comparator{
	HashMap<Integer,Integer> map;
	
	public ValueComparator(HashMap<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Object o1, Object o2) {
		Integer a=(Integer)o1;
		Integer b=(Integer)o2;
		if(map.get(a)==map.get(b)) return 0;
		else
			
		return (map.get(a)>map.get(b))?1:-1;
	}
	
	
}
