package backtrack;

public class FillNumbers {
	public static void main(String[] args) {
		int n=3;
		int[] a=new int[2*n];
		if(new FillNumbers().fill(n,n,a)==false)
			System.out.println("solution doesn't exists");
	}

	private boolean fill(int n, int curr, int[] a) {
		if(curr==0){
			for(int i:a)
				System.out.print(i+" ");
			System.out.println();
			return true;
		}
		for(int i=0;i<2*n-curr-1;i++) {
			if(a[i]==0 && a[i+curr+1]==0) {
				a[i]=a[i+curr+1]=curr;
				if(fill(n,curr-1,a)==true)
					return true;
				else
				a[i]=a[i+curr+1]=0;
			}
		}
		return false;
	}

}
