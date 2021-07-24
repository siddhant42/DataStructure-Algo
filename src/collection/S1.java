package collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class S1 {
	public static Map<String,String> sortByValue(Map<String,String> unsortedMap){
		List<Entry<String,String>> list = new LinkedList<>(unsortedMap.entrySet());
		Collections.sort(list,new Comparator<Entry<String,String>>(){

			@Override
			public int compare(Entry<String,String> a, Entry<String,String> b) {
				return a.getValue().compareTo(b.getValue());
			}

		});
		Map<String,String> sortedMap = new LinkedHashMap<>();
		for(Entry<String,String> e: list){
			sortedMap.put(e.getKey(),e.getValue());
		}
		return sortedMap;
	}
public static void main(String[] args) {
	Map<String,String> m = new HashMap<>();
	m.put("1", "Ram");
	m.put("5", "sid");
	m.put("3", "akshay");
	m.put("2", "yadav");
/*	Map<String,Integer> m = new HashMap<>();
	m.put("Ram",1);
	m.put( "sid",5);
	m.put("akshay",3);
	m.put( "yadav",2);*/
	Map<String,String> map =sortByComparator(m);

	System.out.println(map);
}
private static Map<String, String> sortByComparator(Map<String, String> unsortMap)
{

	List<Entry<String, String>> list = new LinkedList<Entry<String, String>>(unsortMap.entrySet());

	// Sorting the list based on values
	Collections.sort(list, new Comparator<Entry<String, String>>()
	{
		public int compare(Entry<String, String> o1,
				Entry<String, String> o2)
		{
			
				return o1.getValue().compareTo(o2.getValue());
			
		
		}
	});

	// Maintaining insertion order with the help of LinkedList
	Map<String, String> sortedMap = new LinkedHashMap<String, String>();
	for (Entry<String, String> entry : list)
	{
		sortedMap.put(entry.getKey(), entry.getValue());
	}

	return sortedMap;
}
public static void printMap(Map<String, String> map)
{
	for (Entry<String, String> entry : map.entrySet())
	{
		System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
	}
}
}