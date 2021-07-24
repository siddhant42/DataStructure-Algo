package tree;

import java.io.File;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Solution obj = new Solution();
		String str = "GEEKSFORGEEKS";
		System.out.println(obj.findMax(str.toCharArray(), 0, str.length()-1));
	}
	public int findMax(char[] s,int i,int n) {
		if(s==null || s.length==0) return 0;
		if(i==n) return 1;
		if(i==n-1 && s[i]==s[n]) return 2;
		if(s[i]==s[n]) return findMax(s,i+1,n-1)+2;
		//if(isPal(s,i,n)) return n-i+1;
		else {
			return Math.max(findMax(s,i,n-1), findMax(s,i+1,n));
		}
	}
	boolean isPal(char[] s,int i,int n) {
		//if(s==null || s.length==0||s.length==1) return true;
		int j = n;
		while(i<j) {
			if(s[i]!=s[j]) return false;
			i++;j--;
		}
		return true;
	}
}