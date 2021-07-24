package string;

import java.util.Arrays;
import java.util.Comparator;

public class SortByString {
public static void main(String[] args) {
	String s1 = "siddhant";
	String s2 = "hind";
	Character[] ch = new Character[s1.length()];
	for(int i=0;i<ch.length;i++){
		ch[i]=s1.charAt(i);
	}
	for(int i=0;i<ch.length;i++)
		System.out.print(ch[i]);
	System.out.println();
	StringSort obj = new StringSort();
	Arrays.sort(ch,obj);
	for(int i=0;i<ch.length;i++){
		System.out.print(ch[i]);
	}
}
}
class StringSort implements Comparator<Character>{
	String s2 = "hind";
	@Override
	public int compare(Character o1, Character o2) {
		int idx1 = s2.indexOf(o1);
		int idx2 = s2.indexOf(o2);
		if(idx2>=0&&idx1>=0)
			return idx1-idx2;
		else if(idx1>=0)
			return -1;
		else if(idx2>=0)
			return 1;
		else
			return o1-o2;
	}
	
}