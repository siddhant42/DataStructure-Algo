package backtrack;

public class RatonMaze {
public static void main(String[] args) {
	new RatonMaze().solve();
}
int n=5;
private int[][] generateproblem(){
	int[][] p={
			{1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1}
            
	};
return p;
}
private void solve(){
	int[][] sol=new int[n][n];
	int maze[][]=new int[n][n];
	sol=generateproblem();
	if(solveRec(0,0,1,sol,maze)==false){
		printdata(sol);
		System.out.println("solution does not exist");
		return;
	}
	else 
	/*	{for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(sol[i][j]==5)
					sol[i][j]=1;
				else
					sol[i][j]=0;
			}
		}
			
		printdata(sol);}*/
		printdata(maze);
}
private void printdata(int[][] sol){
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++)
			System.out.print(sol[i][j]+"  ");
		System.out.println();
	}}
private boolean isSafe(int row,int col,int[][] sol){
	if(row>=n ||col>=n || sol[row][col]==0) 
		return false;
	return true;
}
boolean solveRec(int row,int col,int moves,int[][] sol,int[][] maze){
	//if(moves==n*2) return true;
	if(row==(n-1) && col==(n-1)){ 
		maze[row][col]=1;
		return true;}
	if(isSafe(row,col,sol)){
		maze[row][col]=1;
		if((solveRec(row+1,col,moves+1,sol,maze)==true)||(solveRec(row,col+1,moves+1,sol,maze)==true))
			return true;
	}
		return false;
}
}
