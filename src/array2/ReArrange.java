package array2;

public class ReArrange {
	public static void find(int[] a) {
		int n = a.length;
		for(int i=0;i<n;i++)
			a[i]++;
		for(int i=0;i<n;i++) {
			if(a[i]>0) reArrange(a,n,i);
		}
		for(int i=0;i<n;i++) {
			System.out.print(-a[i]-1+" ");
		}
	}

	private static void reArrange(int[] a, int n, int i) {
		int val = -(i+1);
		i = a[i]-1;
		while(i>=0 && a[i]>0) {
			int new_val = -(i+1);
			int new_i = a[i]-1;
			a[i]=val;
			val = new_val;
			i = new_i;
		}
		
	}
	public static void main(String[] args) {
		int[] a = {1,3,0,2};
		find(a);
	}
}
