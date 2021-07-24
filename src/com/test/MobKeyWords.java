package com.test;

public class MobKeyWords {
	String words[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	void printwords(int[] num,int idx,String ch){
		if(num==null||num.length==0)
			return;
		if(idx==num.length){
					System.out.print(ch);
			System.out.print(" ");
			return;
		}
		else{
			if(num[idx]==0||num[idx]==1)
				printwords(num,idx+1,ch);
			for(int k=0;k<words[num[idx]].length();k++){
				String newString=ch;
				newString+=words[num[idx]].charAt(k);
				printwords(num,idx+1,newString);
				
			}
			
		}
	}
	public static void main(String[] args) {
		int[] num={7,1,8};
		String ch="";
		//char[] ch=new char[num.length];
		//System.out.println(String.valueOf(ch));
		new MobKeyWords().printwords(num,0,ch);
	}
}
