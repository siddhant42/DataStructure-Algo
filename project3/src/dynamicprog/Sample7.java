package dynamicprog;

import java.util.Arrays;

public class Sample7 {
public static void main(String[] args) {
	int[] a={9,2,3,5,9,3,3,6,2};
	new Sample7().find(a);
}
private void find(int[] a){
	if(a==null||a.length==0){
		System.out.println("given array is empty");
		return;
	}
	int max=0,max_value=0,max_len=maxfun(a);
	int[] h=new int[max_len+1];
	//Arrays.fill(h, 0);
	for(int i=0;i<a.length;i++){
		h[a[i]]++;
		if(max<h[a[i]]){
			max=h[a[i]];
			max_value=a[i];
			}
		System.out.print(max_value+" ");
	}
}
int maxfun(int[] a){
	int max=a[0];
	for(int i=1;i<a.length;i++){
		if(max<a[i]) max=a[i];
	}
	return max;
}
}
