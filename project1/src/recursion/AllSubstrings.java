package recursion;

import java.util.Set;
import java.util.TreeSet;

public class AllSubstrings {
	public static void findSubstring(String s) {
		if(s==null) return;
		Set<String> set = new TreeSet<>();
		for(int i=0;i<s.length();i++) {
			for(int j=1;j<=s.length()-i;j++) {
				String subs = s.substring(i,i+j);
				set.add(subs);
				//System.out.println(subs);
			}
		}
		String first="",last="";
		boolean flag =true;
		for(String st : set) {
			int n = st.length();
			if("aeiou".contains(st.subSequence(0, 1)) && flag && !"aeiou".contains(st.subSequence(n-1, n)))
		 {
				flag =false;
				first = st;
				last = st;
			}
			if("aeiou".contains(st.subSequence(0, 1)) && !"aeiou".contains(st.subSequence(n-1, n)))
			 {
					flag =false;
					last = st;
				}
		}
		System.out.println(first);
		System.out.println(last);
	}
	public static void main(String[] args) {
		String s = "aba";
		findSubstring(s);
	}
}
