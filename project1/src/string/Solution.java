package string;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("I:/input.txt"));
        int n = sc.nextInt();
        int q = sc.nextInt();
        String str = sc.next();
        char[] ch = str.toCharArray();
        while(q>0) {
        	int i = sc.nextInt()-1;
        	int j = sc.nextInt();
        	int len = j-i;
        	String s1 = String.valueOf(ch,i,len);
            char[] ch1 = s1.toCharArray();
            int[] h1 = new int[26];
            Arrays.fill(h1,-1);
            for(int l=0;l<ch1.length;l++) {
    		if(h1[ch1[l]-97]==-1)
    			h1[ch1[l]-97]=l;
    		}
            int count = 0;
        	for(int k=0;k<=n-len;k++) {
        		String s2 = String.valueOf(ch,k, len);
        		if(isSimilar(ch1,s2.toCharArray(),h1)) count++;
        	}
        	System.out.println(count);
        	q--;
        }
        sc.close();
    }
    public static boolean isSimilar(char[] s1,char[] s2,int[] h1) {
    	int[] h2 = new int[26];
        Arrays.fill(h2,-1);
        for(int i=0;i<s2.length;i++) {
    		if(h2[s2[i]-97]==-1){
    			h2[s2[i]-97]=i;
    		}
    		if(h1[s1[i]-97]!=h2[s2[i]-97]) 
    			return false;
    	}
    	return true;
    }
}