package backtrack2;

public class Nqueen {
public static void main(String[] args) {
	long sttime=System.currentTimeMillis();
	new Nqueen().solve();
	long endtime=System.currentTimeMillis();
	System.out.println("total time for execution= "+(endtime-sttime)+" milisec");
}
int n=9;
void solve(){
	int[][] sol=new int[n][n];
	if(solveRec(0,sol)==false){
		System.out.println("solution does not exists");
		return;
	}
	else
		printdata(sol);
}
void printdata(int[][] sol){
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++)
			System.out.print(sol[i][j]+" ");
		System.out.println();
	}
}
boolean isSafe(int row,int col,int[][] sol){
	if(row>=n||col>=n) return false;
	int i,j;
	for(i=0;i<n;i++){
		if(sol[i][col]==1) return false;}
		for(j=0;j<n;j++){
			if(sol[row][j]==1) return false;}
		for(i=row,j=col;((i>=0)&&(j>=0));i--,j--){
			if(sol[i][j]==1)return false;
		}
		for(i=row,j=col;((i<n)&&(j>=0));i++,j--){
			if(sol[i][j]==1)return false;
		}
		for(i=row,j=col;((i>=0)&&(j<n));i--,j++){
			if(sol[i][j]==1)return false;
		}
	return true;
}
boolean solveRec(int col,int[][] sol){
	
	if(col==n) return true;
	for(int row=0;row<n;row++){		
		
	if(isSafe(row,col,sol)){
		sol[row][col]=1;
				if (solveRec(col+1,sol)==true)
			return true;
		else
			sol[row][col]=0;
	}
	
	}
	return false;
}
}
