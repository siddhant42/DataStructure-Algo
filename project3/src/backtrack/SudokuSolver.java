package backtrack;

public class SudokuSolver {
public static void main(String[] args) {
	new SudokuSolver().solve();
}
int n=9,row,col;
private void solve(){
	int[][] sol=new int[n][n];
	if(solveRec(sol,0)==false){
		//printdata(sol);
		System.out.println("solution does not exist");
		return;
	}
	else printdata(sol);
}
private void printdata(int[][] sol){
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++)
			System.out.print(sol[i][j]+"  ");
		System.out.println();
	}
	
}
private boolean isSafe(int x,int y,int[][] sol,int val){
	int i,j,strow,stcol;
	for(i=0,j=y;i<n;i++){
		if(sol[i][j]==val) return false;
	}
	for(j=0,i=x;j<n;j++){
		if(sol[i][j]==val) return false;
	}
	strow=x-(x%3);
	stcol=y-(y%3);
	for(i=strow;i<strow+3;i++){
		for(j=stcol;j<stcol+3;j++)
			if(sol[i][j]==val) return false;
	}
	return true;
}
boolean unassignedLocation(int[][] sol){
	for(row=0;row<n;row++){
		for(col=0;col<n;col++){
			if(sol[row][col]==0) return true;
		}
	}
	return false;
}
boolean solveRec(int[][] sol,int st){
/*	if(unassignedLocation(sol)==false)
		return true;*/
int row,col;
for(row=0;row<n;row++){
	for(col=0;col<n;col++){
		if(sol[row][col]==0){

	for(int k=1;k<=n;k++){
		if(isSafe(row,col,sol,k)){
			sol[row][col]=k;
			//printdata(sol);
			if(solveRec(sol,st+1)==true)
					return true;
			sol[row][col]=0;
			
		}	
	}
return false;
	}}
}
return true;
}
}
