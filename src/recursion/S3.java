package recursion;

import java.util.HashSet;
import java.util.Set;

public class S3 {
	public void permute(char[] s, int currIndex,Set<String> set) {
        if (currIndex == s.length - 1) {
        	set.add(String.valueOf(s));
            return;
        }
        
        for (int i = currIndex; i < s.length; i++) {
            char tmp = s[currIndex];
            s[currIndex] = s[i];
            s[i] = tmp;
            permute(s, currIndex + 1,set);
            char tmp2 = s[currIndex];
            s[currIndex] = s[i];
            s[i] = tmp2;
        }
    }
	public static void main(String[] args) {
		S3 obj = new S3();
		String str = "10 2 4 4";
		String st = str.replace(" ", "");
		Set<String> set = new HashSet<>();
		obj.permute(st.toCharArray(), 0, set);
		for(String s:set) {
			int [] a = new int[s.length()];
			for(int i=0;i<a.length;i++) {
				a[i] = Integer.parseInt(s.substring(i, i+1));
			}
			for(int i:a) {
				System.out.print(i);
			}
			System.out.println();
		}
		
	}
}
