package backtrack2;

import java.util.Arrays;

public class KnightMove {
public static void main(String[] args) {
	KnightMove obj=new KnightMove();
	long starttime=System.currentTimeMillis();
	obj.solveKT();
	long endtime=System.currentTimeMillis();
	System.out.println("total time of execution= "+(endtime-starttime)+" milliseconds");
}
int n=8;
public void solveKT(){
	int[][] sol=new int[n][n];
	int xmove[]={2, 1,-1, -2, -2, -1,  1,  2};
	int ymove[]={1, 2, 2,  1, -1, -2, -2, -1};
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			sol[i][j]=-1;
		}
	}
	sol[0][0]=0;
	if(solveKTRec(0,0,1,sol,xmove,ymove)==false){
		System.out.println("solution does not exist");
				return;
	}
	else
		printdata(sol,n);
}
private boolean isSafe(int x,int y,int[][] sol){
	if(x>=0 && x<8 && y>=0 && y<8 && sol[x][y]==-1)
		return true;
	return false;
}
private void printdata(int[][] sol,int n){
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			System.out.print(sol[i][j]+" ");
		}
		System.out.println();
		}}
private boolean solveKTRec(int x,int y,int movei,int[][] sol,int[] xmove,int[] ymove){
	int n=8, next_x, next_y;
	if(movei==n*n) return true;
	
		for(int k=0;k<n;k++){
			next_x=x+xmove[k];
			next_y=y+ymove[k];
			if(isSafe(next_x,next_y,sol)){
			sol[next_x][next_y]=movei;
			if(solveKTRec(next_x,next_y,movei+1,sol,xmove,ymove)==true){
				return true;
				
			}
			else
				sol[next_x][next_y]=-1;
			}}
	return false;
}
}
