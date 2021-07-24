package other;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sortbyvalue {
public static void main(String[] args) {
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	hm.put(2, 5);
	hm.put(8, 15);
	hm.put(1, 10);
	hm.put(3, 8);
	Set<Map.Entry<Integer,Integer>> s=hm.entrySet();
	for(Map.Entry<Integer,Integer> m:s){
		System.out.println(m.getKey()+" "+m.getValue());}
		ValueComparator2 obj=new ValueComparator2(hm);
		TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>(obj);
		tm.putAll(hm);
		System.out.println("after sorting");
		Set<Integer> s2=tm.keySet();
		for(Integer m:s2){
			System.out.println(m+" "+tm.get(m));}	
	
	
}
}
class ValueComparator2 implements Comparator{
	HashMap<Integer,Integer> m;
public ValueComparator2(HashMap<Integer,Integer> m){
	this.m=m;
}
	@Override
	public int compare(Object o1, Object o2) {
		Integer a=(Integer)o1;
		Integer b=(Integer)o2;
		if(m.get(a)==m.get(b)) return 0;
		else
			return (m.get(a)>m.get(b))?1:-1;
	}
	
}