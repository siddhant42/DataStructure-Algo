package dynamic2;
/**
 * There are N stations on route of a train. The train goes
 *  from station 0 to N-1. The ticket cost for all pair of
 *  stations (i, j) is given where j is greater than i.
 *  Find the minimum cost to reach the destination.
 *  Consider the following example:
 *  Input: 
 *  cost[N][N] = { {0, 15, 80, 90},
 *                {INF, 0, 40, 50},
 *                {INF, INF, 0, 70},
 *                {INF, INF, INF, 0}
 *               };
 *  There are 4 stations and cost[i][j] indicates cost to reach j
 *  from i. The entries where j < i are meaningless.
 *  output:
 *  The minimum cost is 65
 *  
 * @author Siddhant Kumar
 *
 */
public class MinCost {

	public static final int INF = Integer.MAX_VALUE;
	// recursively
	public int minDistance(int[][] cost,int n){
		if(cost==null||cost.length==0) return 0;
		return minDistance(cost,0,n);
	}
	private int minDistance(int[][] a,int st,int n) {
		if(st==a.length) return 0;
		int min = a[st][n-1];
		for(int i=st+1;i<n;i++) {
			min = Math.min(min, a[st][i]+minDistance(a,i,n));
		}
		return min;
	}
	// dynamic solution
	public int minDistanceDyn(int[][] cost,int n) {
		if(cost==null||cost.length==0) return 0;
		for(int i=1;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				cost[i][j]-=cost[i][j-1];
			}
		}
		for(int i=1;i<n-1;i++)
			cost[i][i+1]+=cost[i-1][i];
		for(int i=1;i<(n-2);i++){
			for(int j=(i+2);j<n;j++) {
				cost[i][j] += Math.min(cost[i][j-1], cost[i-1][j-1]);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++)
			min = Math.min(min, cost[i][n-1]);
		return min;
	}
	public static void main(String[] args) {
		int cost[][] = { {0, 15, 80, 90},
	                     {INF, 0, 40, 50},
	                     {INF, INF, 0, 70},
	                     {INF, INF, INF, 0}
	             };
		System.out.println(new MinCost().minDistanceDyn(cost, cost.length));
	}

}
