package string;

import java.util.ArrayList;

public class LCS {
	String find(String[] str){
		if(str==null) return null;
		String r=str[0];
		for(int i=1;i<str.length;i++)
			r=Lcommon(r,str[i]);
		return r;
	}
	String Lcommon(String s1,String s2){
		char[] s=s1.toCharArray(),t=s2.toCharArray();
		String ch="";
		for(int i=0;i<s.length;i++){
			if(s[i]==t[i])
				ch+=s[i];
			else break;
		}
		return ch;
	}
public static void main(String[] args) {
	String[] s={"abcd","abbd","az"};
	String t=new LCS().find(s);
	System.out.println(t);
}
}
