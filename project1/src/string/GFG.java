package string;

import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0) {
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		sc.nextLine();
		String s1 = sc.next();
		String s2 = sc.next();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int max = find(c1,c2,n1,n2);
		System.out.println(max);
		t--;
		}
		sc.close();
		
	}
/*	public static int find(char[] s1,char[] s2,int i,int j,int n1,int n2){
	    if(i==n1) return n2-j;
	    if(j==n2) return n1-i;
	    if(s1[i]==s2[j]) 
	    return find(s1,s2,i+1,j+1,n1,n2);
	    else {
	        return 1+ Math.min( find(s1,s2,i+1,j,n1,n2),
	        Math.min(find(s1,s2,i,j+1,n1,n2),find(s1,s2,i+1,j,n1,n2)));
	    }
	}*/
	public static int find(char[] s1,char[] s2,int n1,int n2) {
		int[][] dp = new int[n1+1][n2+1];
		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				if(i==0 ) dp[i][j] = j;
				else if (j==0) dp[i][j] = i;
				else {
					int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
					if(s1[i-1]==s2[j-1]) 
						dp[i][j] = dp[i-1][j-1];
					else
						dp[i][j] = 1 + min;
				}
			}
		}
		return dp[n1][n2];
	}
}