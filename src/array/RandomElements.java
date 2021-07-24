package array;

public class RandomElements {
	public void randomize(int[] a) {
		if(a==null||a.length==0||a.length==1) return;
		int n = a.length;
		for(int i=n-1;i>=0;i--) {
			int idx = (int) Math.random()*(i+1);
			swap(a,i,idx);
		}
		printArray(a);
	}

	private void printArray(int[] a) {
		if(a==null || a.length==0) return;
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	private void swap(int[] a, int i, int idx) {
		if(i<0 || idx<0) return;
		int tmp = a[i];
		a[i] = a[idx];
		a[idx] = tmp;
	}
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6};
		RandomElements obj = new RandomElements();
		obj.randomize(a);
		System.out.println();
		obj.randomize(a);
		System.out.println();
		obj.randomize(a);
		System.out.println();
		obj.randomize(a);
		System.out.println();
		obj.randomize(a);
	}
}
