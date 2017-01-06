package dynamicprog;

import java.util.Arrays;

public class Sample6 {
public static void main(String[] args) {
	String str="gheeg";
	System.out.println(new Sample6().find(str));
}
String find(String str){
	int i,curr_len=0,max_len=0,prev_idx,end=0;
	int[] h=new int[256];
	Arrays.fill(h, -1);
	char[] a=str.toCharArray();
	//h[a[0]]=0;
	
	for(i=0;i<a.length;i++){
		prev_idx=h[a[i]];
		if(prev_idx==-1||i-curr_len>prev_idx){
			curr_len++;
		
		}
		else{
			if(max_len<curr_len){
				max_len=curr_len;
			end=i;	
			}
			curr_len=i-prev_idx;
		}
		h[a[i]]=i;
	}
	if(max_len<curr_len){
		max_len=curr_len;
	end=i;	
	}
	//System.out.println(end+" "+max_len);
	return str.substring(end-max_len,end);
}

}
