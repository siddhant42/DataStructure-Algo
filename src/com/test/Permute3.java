package com.test;

public class Permute3 {
	void printwords(String s1,String s2){
		String s3="";
		printwordsrec(s1,s2,s3,0);
	}
	void printwordsrec(String s1,String s2,String s3,int st1){
		if(s3.length()==2){
			System.out.println(s3);
			return;
		}
		else{
			for(int i=st1;i<s1.length();i++){
					s3+=s1.charAt(i);
					for(int j=st1;j<s2.length();j++){
						s3+=s2.charAt(j);
						printwordsrec(s1,s2,s3,st1+1);
					}
							}}
				
	
	}
public static void main(String[] args) {
	String s1="abc";
	String s2="def";
	new Permute3().printwords(s1,s2);
}
}
