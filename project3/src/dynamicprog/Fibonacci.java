package dynamicprog;

public class Fibonacci {
	int find(int n){
		if(n<0){
			System.out.println("can't determine fibonacci of given number");
			return -1;
		}
		int[] fib=new int[n+1];
		fib[0]=0;
		fib[1]=fib[2]=1;
		for(int i=3;i<=n;i++)
			fib[i]=fib[i-1]+fib[i-2];
		return fib[n];
	}
public static void main(String[] args) {
	System.out.println(new Fibonacci().find(7));
}
}
