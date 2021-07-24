package array;

public class NthPrime {
	public static void main(String[] args) {
		int n=180;
		int[] primes = new NthPrime().find(n);
		for(int i=0;i<n;i++)
			System.out.println(primes[i]);
	}

	private int[] find(int n) {
		int[] primes = new int[n];
		int count=0;
		boolean flag=true;
		primes[count++]=2;
		for(int i=3;i<Integer.MAX_VALUE;i+=2){
			if(count==n) return primes;
			flag = true;
			for(int j=0;j<count;j++){
				int p = primes[j];
				if(p*p<=i && i%p==0){
					flag = false;
					break;
				}
			}
			if(flag) primes[count++]=i;
		}
		return primes;
	}
}
