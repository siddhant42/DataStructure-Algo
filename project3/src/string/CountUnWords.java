package string;
import java.util.*;
public class CountUnWords {
public int countWords(String abc){
	int cnt=0;
	if(abc.isEmpty()) {
	System.out.println("given string is empty");
	return 0;
		}
	List<String> list=Arrays.asList(abc.split("[\\W]+"));
	//List<String> list=new ArrayList<String>(abc.split(" "));
	Set<String> s=new HashSet<String>(list);
	for(String word:s){
	if(Collections.frequency(list, word)==1) cnt++;
	}
	return cnt;
}
	public static void main(String[] args) {
	CountUnWords obj=new CountUnWords();
		String abc="this is siddhant  and this, is it";
		int cnt=obj.countWords(abc);
		if(cnt!=0)
			System.out.println("number of unique words are "+cnt);
		
}
}
