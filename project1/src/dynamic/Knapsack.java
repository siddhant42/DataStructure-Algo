package dynamic;

import java.util.Scanner;

public class Knapsack {

	 public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      int m =sc.nextInt();
	      while(m>0){
	      int n = sc.nextInt();
	      int sum = sc.nextInt();
	      int[] a = new int[n];
	      for(int i=0;i<n;i++){
	    	  a[i]=sc.nextInt();
	      }
	      Knapsack obj = new Knapsack();
	       int min=0;
	       //min=obj.find(a,sum,a.length);
	       min = obj.findDynamic(a,sum,a.length);
	       System.out.println(sum-min);
	    }
	      sc.close();
	      }
	private int findDynamic(int[] a, int sum,int n) {
		int[][] s = new int[sum+1][n+1];
		for(int i=0;i<=sum;i++)
			s[i][0]=i;
		for(int j=0;j<=n;j++)
			s[sum][0]=0;
		for(int i=1;i<=sum;i++){
			for(int j=1;j<=n;j++){
				if((i-a[j-1])>=0)
				s[i][j]=Math.min(s[i-a[j-1]][j], s[i][j-1]);
			}
		}
		return s[sum][n];
	}
	private int find(int[] a, int sum,int n) {
		int min=0;
		if(n==0) return sum;
		if(sum==0) return 0;
		else if(sum<0) return Integer.MAX_VALUE;
		if(sum>0) {
		min = Math.min(find(a,sum-a[n-1],n),find(a,sum,n-1));
		}
		return min;
		}
	
}
