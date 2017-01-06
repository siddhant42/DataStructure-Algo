package dynamicprog;

public class Sample3 {
	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int max=new Sample3().find(a);
		System.out.println(max);
	}
	int max(int a,int b){
		return a>b?a:b;
	}
	int find(int[] a){
		if(a==null||a.length==0){
			System.out.println("array is empty");
			return -1;
		}
		int m=a[0],maxsofar=a[0];
		for(int i=1;i<a.length;i++){
			m=max(a[i],m+a[i]);
			if(maxsofar<m)
				maxsofar=m;
		}
	return maxsofar;
	}
}
