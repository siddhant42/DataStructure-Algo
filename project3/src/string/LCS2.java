package string;

import java.util.regex.Pattern;

public class LCS2 {
	boolean find(String s){
		if(s==null||s.length()==0) return true;
		char[] str=s.toCharArray();
		for(int i=1;i<=str.length;i++){
			String p=s.substring(0,i);
			String reg="("+p+")"+"{2,}";
			//System.out.println(reg);
			if(Pattern.matches(reg,s ))
				return true;
		}
			return false;
	}
public static void main(String[] args) {
	//String reg="abc{1,}";
	String s="abab";
	System.out.println(new LCS2().find(s));
}
}
