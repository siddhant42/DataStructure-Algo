package array3;

import java.util.ArrayList;
import java.util.List;

public class Sample1 {
	ArrayList<Integer> m(int[] a,int n){
		int i;
	ArrayList<Integer> result=new ArrayList<Integer>();
	int[] s=new int[n];
	for(i=0;i<a.length;i++)
		s[a[i]]++;
	for(i=0;i<n;i++){
		if(s[i]>1){
		while(s[i]>0){
			//result[j++]=i;
			result.add(i);
			s[i]--;
		}
			}}


	return result;
	}
public static void main(String[] args) {
	int[] a={1,2,3,7,8,2,5,7,9,2};
Sample1 s=new Sample1();
ArrayList<Integer> result=s.m(a,10);
//for(int i=0;i<result.capacity();i++)
//System.out.println(result.get(i));
System.out.println(result);
}

	}

