package com.test;

import java.util.HashSet;

public class Permute {
	public void printwords(char[] a,int st,int n){
		String perm="";
		permutation(perm,String.valueOf(a));
	}
	private void permutation(String perm, String word) {
		if (word.isEmpty()) { 
			//System.out.print((perm + word)+" "); 
			String words=perm + word;
			hs.add(words);
		} 
		else { 
			for (int i = 0; i < word.length(); i++) { 
				permutation(perm + word.charAt(i), word.substring(0, i) +
						word.substring(i + 1, word.length()));
			}
		}	
	}
	
	HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		Permute obj = new Permute();
		String str = "abca";
		obj.printwords(str.toCharArray(),0, 3);
				for(String str2 : obj.hs)
					System.out.print(str2+" ");
	}
}
