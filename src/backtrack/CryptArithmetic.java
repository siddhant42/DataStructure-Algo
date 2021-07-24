package backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CryptArithmetic {
	String a = "send";
	String b = "more";
	String c ="money";

	public static void main(String[] args) {
		Map<Character,Integer> hm = new HashMap<>();
		CryptArithmetic obj = new CryptArithmetic();
		Set<Character> s = new HashSet<>();
		for(char ch:obj.a.toCharArray())
			s.add(ch);
		for(char ch:obj.b.toCharArray())
			s.add(ch);
		for(char ch:obj.c.toCharArray())
			s.add(ch);
		char[] ch = new char[s.size()];
		int i=0;
		for(char p:s)
			ch[i++]=p;
		for(char p:ch)
			System.out.print(p+" ");
		System.out.println();
		if(obj.solution(ch,0,hm)==false)
			System.out.println("no solution exists");
		else{
			System.out.println(hm);
		}
	}

	private boolean solution(char[] ch, int idx, Map<Character, Integer> hm) {
		if(hm.size()==ch.length)
			return solvedPuzzle(hm);
		for(int i=0;i<10;i++) {
			if(isSafe(hm,i,ch[idx])) {
				hm.put(ch[idx], i);
				if(solution(ch,idx+1,hm)==true)
					return true;
				else
					hm.remove(ch[idx]);
			}
		}
		return false;
	}

	private boolean solvedPuzzle(Map<Character, Integer> hm) {
		int add1=0,add2=0,sum=0;
		int n1=a.length();
		int n2=b.length();
		int n3=c.length();
		for(int i=n1-1;i>=0;i--){
			add1+=hm.get(a.charAt(i))*Math.pow(10, n1-i-1);
		}
		for(int i=n2-1;i>=0;i--){
			add2+=hm.get(b.charAt(i))*Math.pow(10, n2-i-1);
		}
		for(int i=n3-1;i>=0;i--){
			sum+=hm.get(c.charAt(i))*Math.pow(10, n3-i-1);
		}
		if(add1+add2==sum)
			return true;
		return false;
	}

	private boolean isSafe(Map<Character, Integer> hm, int i,char ch) {
		if(i==0 &&(a.charAt(i)==ch||b.charAt(i)==ch||c.charAt(i)==ch))
			return false;
		Set<Character> set = hm.keySet();
		for(char p:set){
			if(hm.get(p)==i) return false;
		}
		return true;
	}
}
