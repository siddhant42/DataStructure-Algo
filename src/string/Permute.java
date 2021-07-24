package string;

import java.util.ArrayList;
import java.util.Collections;

public class Permute {
void swap(char[] s,int i,int j){
	char tmp=s[i];
	s[i]=s[j];
	s[j]=tmp;	
}
void permute(char[] s,int st,int end){
	if(s==null||s.length==0) return;
	if(st==end){
		list.add(String.valueOf(s));
		return;
	}
	else{
		for(int j=st;j<=end;j++){
			swap(s,st,j);
			permute(s,st+1,end);
			swap(s,st,j);
		}
	}
}
ArrayList<String> list=new ArrayList<String>();
public static void main(String[] args) {
Permute obj=new Permute();
char[] s="abc".toCharArray();
obj.permute(s, 0, s.length-1);
Collections.sort(obj.list);
for(String str:obj.list)
	System.out.print(str+" ");
}
}
