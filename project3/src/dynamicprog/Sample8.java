package dynamicprog;

public class Sample8 {
public static void main(String[] args) {
	System.out.println(new Sample8().eggdrop(2,100));
}
int max(int a,int b){
	return a>b?a:b;
}
int eggdrop(int n,int k){
	int i,j,x,min,res;
	int[][] eggfloor=new int[n+1][k+1];
	for(i=1;i<=n;i++){
		eggfloor[i][0]=0;
		eggfloor[i][1]=1;
	}
	for(j=1;j<=k;j++)
		eggfloor[1][j]=j;
	for(i=2;i<=n;i++){
		for(j=2;j<=k;j++){
			eggfloor[i][j]=Integer.MAX_VALUE;
			for(x=1;x<=j;x++){
				res=1+max(eggfloor[i-1][x-1],eggfloor[i][j-x]);
				if(eggfloor[i][j]>res)
					eggfloor[i][j]=res;
			}
		}
	}
	return eggfloor[n][k];
}
}
