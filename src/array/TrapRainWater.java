package array;

/**
 * Trapping rain water problem
 * @author kumarsid
 *
 */
public class TrapRainWater {
	int findMax(int[] a) {
		if(a==null || a.length==0||a.length==1) return 0;
		int max = 0;
		int n = a.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = a[0];
		right[n-1] = a[n-1];
		for(int i=1;i<n;i++)
			left[i] = Math.max(left[i-1], a[i]);
		for(int i=n-2;i>=0;i--)
			right[i] = Math.max(right[i+1], a[i]);
		for(int i=1;i<n-1;i++)
			max+=Math.abs(Math.min(left[i], right[i]))-a[i];
		return max;
	}
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int sum = new TrapRainWater().findMax(arr);
		System.out.println(sum);
	}
}
