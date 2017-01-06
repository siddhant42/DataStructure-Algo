package collections;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

class TestCollection15{  
	 public static void main(String args[]){  
	   
		 Hashtable<Integer,String> hm=new Hashtable<Integer,String>();  
	  
	  hm.put(100,"Amit");  
	  hm.put(0,"Ravi");  
	  hm.put(0,"Vijay");  
	  hm.put(103,"Rahul");  
	  
	  for(Map.Entry m:hm.entrySet()){  
	   System.out.println(m.getKey()+" "+m.getValue());  
	  }  
	 }  
	}
