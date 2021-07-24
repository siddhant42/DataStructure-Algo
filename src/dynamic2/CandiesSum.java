package dynamic2;

public class CandiesSum {
	long find(String str,int len,int n,long sum) {
		if(len==n+1) return sum;
		for(int i=0;i<=n-len;i++) {
			sum+=Long.parseLong(str.substring(i,i+len)); 
		}
		return find(str,len+1,n,sum);
	}
	public static void main(String[] args) {
		CandiesSum obj = new CandiesSum();
		String str = "123";
		long n = obj.find(str,1,str.length(),0);
		long result = (long) (n%(Math.pow(10, 9)+7));
		System.out.println(result);

	}
}
