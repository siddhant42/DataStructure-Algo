package dynamic;

public class CountDigits2 {
	public static void main(String[] args) {
		int n=12;
		int p= find(n,0);
		System.out.println(p);
	}
	static int find(int n,int st){
		int sum=0;
		if(st==n) return sum;
		for(int i=st;i<10;i++) {
			sum+=i;
		find(n,st+1);
		}
		return sum;
	}
}
