package dynamic;

import java.util.Arrays;
/**
 * Given a value V, if we want to make change for V cents,
 * and we have infinite supply of each of C = { C1, C2, .. , Cm}
 * valued coins, what is the minimum number of coins to make the change?
 * 
 * @author kumarsid
 *
 */
public class MinCoinChange {
	public static void main(String[] args) {
		int coins[] =  { 5,2, 1};
		int sum = 9;
		int p = findSum(coins,sum);
		System.out.println(p);
	}
	// recursively
	static int find(int[] coins,int v) {
		if(v==0) return 0;
		int res = Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			if(coins[i]<=v) {
				int subres = find(coins,v-coins[i]);
				if(subres!=Integer.MAX_VALUE && res>subres+1)
					res = subres+1;
			}
		}
		return res;
	}
	// dynamically
	static int findSum(int[] coins,int v){
		int[] s = new int[v+1];
		Arrays.fill(s, Integer.MAX_VALUE);
		s[0]=0;
		for(int i=1;i<s.length;i++) {
			for(int j=0;j<coins.length;j++) {
				if(coins[j]<=i){
					s[i] = Math.min(s[i], 1+s[i-coins[j]]);
				}
			}
		}
		return s[v];
	}
}
