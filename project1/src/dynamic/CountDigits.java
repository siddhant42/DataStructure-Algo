package dynamic;

public class CountDigits {
	public static void main(String[] args) {
		int n = 3, sum = 5;
		int[] a= new int[n];
		new CountDigits().find(a,0,sum);
	}

	private  void find(int[] a, int idx, int sum) {
		if(idx==a.length){
			if(sum==findSum(a,a.length)){
				print(a,0);
			System.out.println();	
			}
			return;
		}
		//if(sum<findSum(a,a.length)) return;
		for(int i=0;i<=9 && i<=sum;i++){
			if(idx==0 && i==0) continue;
			a[idx]=i;
			find(a,idx+1,sum);
		}
		
	}

	private void print(int[] a,int n) {
		if(n==a.length) return;
		System.out.print(a[n]+" ");
		print(a,n+1);
	}

	private  int findSum(int[] a,int n) {
		if(n==0) return 0;
		return a[n-1]+findSum(a,n-1);
	}
}
