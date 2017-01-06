package dynamic;

import java.util.Arrays;

public class MinCoinChange {
	public static void main(String[] args) {
		int coins[] =  { 5,2, 1};
		int sum = 9;
		int p = findSum(coins,sum);
		System.out.println(p);
	}

	private static int findSum(int[] coins, int sum) {
		int[] a = new int[sum+1];
		Arrays.fill(a, Integer.MAX_VALUE);
		a[0]=0;
		for(int i=1;i<=sum;i++){
			for(int j=0;j<coins.length;j++){
				if(coins[j]<=i){
					int sub_res=a[i-coins[j]];
					if(sub_res!=Integer.MAX_VALUE && a[i]>(sub_res+1))
						a[i]=sub_res+1;
				}
			}
		}
		return a[sum];
	}

/*	private static int findSum(int[] coins, int sum) {
		if(sum==0) return 0;
		int res = Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++){
			if(coins[i]<=sum){
				int sub_res = findSum(coins,sum-coins[i]);
				if(sub_res!=Integer.MAX_VALUE && res>(sub_res+1))
					res=sub_res+1;
			}
		}
		return res;
	}*/
}
