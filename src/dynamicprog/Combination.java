package dynamicprog;

import java.util.Scanner;

public class Combination {
public static void main(String[] args) {
	int n,k;
	Scanner sc=new Scanner(System.in);
System.out.println("enter superscript and subscript respectively");
n=sc.nextInt();
k=sc.nextInt();
if(n<=0||n<k||k<0)
	System.out.println("can't determine combination for given pair of values");
else{
	//System.out.println("combination of given pair of values is "+new Combination().binRec(n,k));
	System.out.println("factorial of given pair of values is "+new Combination().bindp(n,k));
}
}
long binRec(int n,int k){
	long p;
if(k==0||n==k) return 1;
else if(k==1) return n;
else
	 p= binRec(n-1,k-1)+binRec(n-1,k);
return p;
}

long bindp(int n,int k){
	int i,j;
	long[][] s=new long[n+1][k+1];
	for(i=1;i<=n;i++){
		for(j=0;j<=k;j++){
			if(j==0||j==i)
				s[i][j]=1;
			else
				s[i][j]=s[i-1][j-1]+s[i-1][j];
		}
	}
	return s[n][k];
}
}
