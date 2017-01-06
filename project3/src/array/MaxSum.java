package array;

public class MaxSum {
	int find(int[] a,int k){
		if(a==null||a.length==0)
			return 0;
		int max1=a[0],max=a[0],j=0,n=a.length;
		int[] b=new int[n];
		for(int i=0;(i<k+1)&&(i<n);i++){
			if(max<a[i]) max=a[i];
			b[i]=a[i];}
		for(int i=k+1;i<n;i++){
			b[i]=max1+a[i];
			if(max1<b[i-k])
				max1=b[i-k];
			max=b[i];
		}
		return max;
	}
public static void main(String[] args) {
	int[] a={2,5,1,3,8,7,15,6,13};
	System.out.println(new MaxSum().find(a,2));
}
}
