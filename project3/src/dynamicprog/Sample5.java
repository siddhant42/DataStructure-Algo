package dynamicprog;

import java.util.Arrays;

public class Sample5 {
public static void main(String[] args) {
	String str="BBBB";
	System.out.println(find(str));
}
public static String find(String str){
	if(str==null||str.length()==0) return null;
	int max=0,st=0,i,stidx=0;
	int[] h=new int[256];
	Arrays.fill(h, -1);
	char[] a=str.toCharArray();
	for(i=0;i<a.length;i++){
		System.out.print(h[a[i]]+" ");
		if(st==0&&(h[a[i]]!=-1||i==a.length-1)){
			if(max<i-st){
				max=i-st;
				stidx=st;}
			st=i;
		}
		else if(i==a.length-1||h[a[i]]!=-1){
			if(max<(i-st)){
				stidx=st;
				max=i-st;
				st=i;
			}
			
		}
		h[a[i]]=i;
	}
	//System.out.println(stidx+" "+max);
	return str.substring(stidx,stidx+max);
}
}
