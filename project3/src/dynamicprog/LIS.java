package dynamicprog;

import java.util.Arrays;

public class LIS {
	int find(int[] a,int n){
		if(a==null||a.length==0) return 0;
		int max=Integer.MIN_VALUE;
		int[] b=new int[n];
		Arrays.fill(b, 1);
		for(int i=1;i<n;i++){
			for(int j=i-1;j>=0;j--){
				if(a[j]<a[i] &&b[i]<b[j]+1){
					b[i]=b[j]+1;
					break;
				}
			}
		}
		for(int i=0;i<n;i++){
			if(max<b[i]) max=b[i];
		}
		return max;
	}
public static void main(String[] args) {
	int[] a={1,101,2,3,100,13,4};
	System.out.println(new LIS().find(a,a.length));
}
}
