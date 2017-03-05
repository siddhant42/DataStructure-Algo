package dynamic;

import java.util.Arrays;
/**
 * In a daily share trading, a buyer buys shares in the morning
 * and sells it on same day. If the trader is allowed to make
 * at most 2 transactions in a day, where as second transaction
 * can only start after first one is complete (Sell->buy->sell->buy).
 * Given stock prices throughout day, find out maximum profit that
 *  a share trader could have made.
 *  Examples:
 *  Input:   price[] = {10, 22, 5, 75, 65, 80}
 *  Output:  87
 *  Trader earns 87 as sum of 12 and 75
 *  Buy at price 10, sell at 22, buy at 5 and sell at 80
 *  
 * @author Siddhant Kumar
 *
 */

public class MaxProfit {

	public int findMax(int[] a,int x) {
		int[] s = new int[a.length];
		Arrays.fill(s, -1);
		return findMax(a,s,0,0,0,x);
	}
	// Dynamic Solution
	private int findMax(int[] a,int[] s,int st,int sum,int idx,int x) {
		if(st==x) return sum;
		if(idx==a.length || idx==a.length-1) return 0;
		if(s[idx]!=-1) return s[idx];
		int st1= idx;
		for(int i=idx+1;i<a.length;i++) {
			if(a[st1]>a[i]) st1=i;
			else break;
		}
		if(st1==(a.length-1)) return 0;
		int maxsum=0;
		for(int i=st1+1;i<a.length;i++) {
			if(a[st1]<a[i]) 
				sum = a[i]-a[st1]+findMax(a,s,st+1,0,i+1,x);
			if(maxsum<sum) maxsum = sum;
		}
		return s[idx]=maxsum;
	}
	// Solution with at max 2 transactions in time complexity o(n)
	public int findMax(int[] price) {
		if(price==null || price.length==0||price.length==1) return 0;
		int n = price.length;
		int[] profit = new int[n];
		// get the maximum profit in one transaction
		int maxprice = price[n-1];
		for(int i=n-2;i>=0;i--) {
			if(maxprice<price[i]) maxprice = price[i];
			profit[i] = Math.max(profit[i+1], maxprice-price[i]);
		}
		// maximum profit with 2 transactions
		int minprice = price[0];
		for(int i=1;i<n;i++) {
			if(minprice>price[i]) minprice = price[i];
			profit[i] = Math.max(profit[i-1], profit[i]+price[i]-minprice);
		}
		return profit[n-1];
	}
	public static void main(String[] args) {
		MaxProfit obj = new MaxProfit();
		int[] price = {10, 22, 5, 75, 65, 80};
		// maximum number of transactions allowed
		//int x = 2;
		System.out.println(obj.findMax(price));
	}

}
