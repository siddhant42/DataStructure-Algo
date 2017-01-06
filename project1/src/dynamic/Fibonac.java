package dynamic;

public class Fibonac {
	public static void main(String[] args) {
		Fibonac obj = new Fibonac();
		int n=10;
		obj.fib(n);
		/*int[] b= new int[10];
		int[] a={2,3};
		int res_size=obj.square(a,b, 2, 2);
		for(int i=res_size;i>=0;i--)
		System.out.print(b[i]);*/
	}

	private void fib(int n) {
		int[][] b = new int[n][25];
		b[1][0]=1;
		int res_size=0;
		for(int i=2;i<n;i++) {			
			res_size= square(b[i-1],b[i],res_size+1,res_size+1);
			res_size=sum(b[i-2],b[i],res_size);
		}
		for(int i=res_size;i>=0;i--){
			System.out.print(b[n-1][i]);
		}
	}
	int square(int[] a,int[] b,int n,int res_size){
		int i,j,prod;
		for(i=0;i<n;i++){
			int rem=0;
			for(j=0;j<n;j++){
				if(i==0)
				prod = a[i]*a[j]+rem;
				else
					prod = a[i]*a[j]+b[i+j]+rem;
				b[i+j]=prod%10;
				rem=prod/10;
				res_size=i+j;
			}
			if(rem>0){
				b[i+j]=rem;
				res_size=i+j;
			}
		}
		return res_size;
	}
	int sum(int[] a,int[] b,int res_size){
		int i,rem=0,s;
		for(i=0;i<=res_size;i++){
			s=a[i]+b[i]+rem;
			b[i]=s%10;
			rem=s/10;
		}
		if(rem>0){
			res_size++;
			b[res_size]=rem;
		}
			return res_size;
	}
}
