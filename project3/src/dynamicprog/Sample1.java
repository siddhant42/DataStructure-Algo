package dynamicprog;

public class Sample1 {
	
	public int countSteps(int n){
		int[] dp=new int[n+1];
		dp[1]=0;
		for(int i=2;i<=n;i++){
			dp[i]=1+dp[i-1];
			if(i%2==0) dp[i]=min(dp[i],1+dp[i/2]);
			if(i%3==0) dp[i]=min(dp[i],1+dp[i/3]);
		}
		return dp[n];
	}
	int min(int i,int j){
		return i<j?i:j;
	}
public static void main(String[] args) {
System.out.println(new Sample1().countSteps(10));	
}
}
