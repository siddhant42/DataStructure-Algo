package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountUWords2 {
	public int countWords(String abc){
		if(abc.isEmpty()) {
		System.out.println("given string is empty");
		return 0;
			}
		List<String> list=Arrays.asList(abc.split("\\s"));
		Set<String> s=new HashSet<String>();
		for(String st:list){
		if(s.contains(st))
			s.remove(st);
		else
			s.add(st);
		
		}
		return s.size();
		
	}
		public static void main(String[] args) {
		CountUnWords obj=new CountUnWords();
			String abc="this is siddhant and this is it";
			int cnt=obj.countWords(abc);
			if(cnt!=0)
				System.out.println("number of unique words are "+cnt);
			
	}
}
