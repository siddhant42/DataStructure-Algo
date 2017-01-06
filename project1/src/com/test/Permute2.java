package com.test;

public class Permute2 {
	public void printwords(char[] a,char[] str,int idx,int k){
		if(idx==k){
			for(char c:str)
				System.out.print(c);
			System.out.println();
		} else{
			for(int j=0;j<a.length;j++){
				str[idx]=a[j];
				printwords(a,str,idx+1,k);
			}
		}
	}
public static void main(String[] args) {
	String str="ab";
	int k=3;
	char[] ch=new char[k];
	new Permute2().printwords(str.toCharArray(),ch,0,k);
}
}
