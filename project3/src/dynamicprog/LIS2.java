package dynamicprog;

import java.util.Arrays;

public class LIS2 {
	int find(int[] a,int n){
		if(a==null||a.length==0) return 0;
		int max=Integer.MIN_VALUE,i;
		int[] b=new int[n];
		/*for(i=0;i<n;i++)
			b[i]=a[i];*/
		b=Arrays.copyOf(a, n);
		for(i=1;i<n;i++){
			for(int j=i-1;j>=0;j--){
				if(a[j]<a[i] ){
					b[i]+=b[j];
					break;
				}
			}
		}
		for(i=0;i<n;i++){
			if(max<b[i]) max=b[i];
		}
		return max;
	}
public static void main(String[] args) {
	int[] a={1,101,2,3,100,13,4};
	System.out.println(new LIS2().find(a,a.length));
}
}
