package array3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unique2 {
	public void find(int a[]){
		List list=Arrays.asList(a);
		for(int i:a){
			//if(Collections.frequency(a,i)==1)
				System.out.println(i);
		}
	}
	public static void main(String[] args) {
		Unique2 u=new Unique2();
		int a[]={1,2,2,4,3,3,8,3,3,3,3,3,5,21,9,9,9,9,9,9,9,9,9,9,9,6,8,8,8,8,8,8,8,8,8,8,8,8};
		Arrays.sort(a);
		u.find(a);
	}
}
