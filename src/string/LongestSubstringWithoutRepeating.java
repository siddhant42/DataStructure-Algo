package string;

import java.util.Arrays;

public class LongestSubstringWithoutRepeating {
public static void main(String[] args) {
	String str="abcdklmkjlc";
	System.out.println(find(str));
}
static String find(String str){
if(str==null||str.length()==0) return null;
char[] a=str.toCharArray();
int[] s=new int[256];
int curr_len=1,max_len=0,i,st=0,end=0;
	Arrays.fill(s, -1);
	s[a[0]]=0;
	for(i=0;i<a.length;i++)
		//System.out.print(s[a[i]]+" ");
	//System.out.println();
	for(i=1;i<a.length;i++){
		//st=s[a[i]];
		if(st==-1||s[a[i]]<st)
			curr_len++;
		else{
			if(max_len<curr_len) {
				max_len=curr_len;
				//System.out.println(max_len);
			end=i;
			}
			if(st<s[a[i]]) st=s[a[i]];
			curr_len=i-st;
		}
		s[a[i]]=i;
	}
	if(max_len<curr_len){ 
		max_len=curr_len;
		//System.out.println(max_len);
	end=a.length;;}
	return str.substring(end-max_len,end);
}
}
