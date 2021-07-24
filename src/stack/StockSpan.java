package stack;

import java.util.Stack;
/**
 * The stock span problem is a financial problem where we have a series 
 * of n daily price quotes for a stock and we need to calculate span 
 * of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the 
 * maximum number of consecutive days just before the given day, for which 
 * the price of the stock on the current day is less than or equal to its 
 * price on the given day.
 * For example, if an array of 7 days prices is given as 
 * {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 
 * 7 days are {1, 1, 1, 2, 1, 4, 6}
 * 
 * @author Siddhant Kumar
 *
 */
public class StockSpan {
	// method to calculate the span for given price array and print
	public static void findSpan(int[] price) {
		if(price==null || price.length==0) return;
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<price.length;i++) {
			while(!st.empty() && price[i]>=price[st.peek()])
				st.pop();
			if(st.empty())
				System.out.print(i+1+" ");
			else
				System.out.print(i-st.peek()+" ");
			st.push(i);
		}
	}
	public static void main(String[] args) {
		 int price[] = {10, 4, 5, 90, 120, 80};
		 findSpan(price);
	}
}
