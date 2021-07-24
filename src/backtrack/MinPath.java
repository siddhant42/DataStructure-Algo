package backtrack;

import java.util.Arrays;

public class MinPath {
	public static final int N =4;
	private int[] minimum = new int[100];
	int st=0;
	int[] row={-1,0,0,1};
	int[] col={0,-1,1,0};
	void find(char[][] a,Point s,Point e,int[][] path,int count){
		if(s.equals(e)){
			minimum[st++]=count;
			return;
		}
		for(int i=0;i<row.length;i++){
			s.x+=row[i];
			s.y+=col[i];
			if(isValidPath(s,a,path)){
				path[s.x][s.y]= 1;
				find(a,s,e,path,count+1);
				path[s.x][s.y]=0;
			}
			s.x-=row[i];
			s.y-=col[i];
		}
	}
	boolean isValidPath(Point s,char[][] a,int[][] path){
		if(s.x<0||s.x>=N||s.y<0||s.y>=N||a[s.x][s.y]=='X'||a[s.x][s.y]=='S'||isInPath(s,path) )
			return false;
		return true;
	}
	boolean isInPath(Point s,int[][] path){
		if(path[s.x][s.y]==0) return false;
		return true;
	}
	public static void main(String[] args) {
		MinPath obj = new MinPath();
		Arrays.fill(obj.minimum, -1);
		char arr[][]={    {'1','1','1','1','1'},
						  {'1','S','X','1','1'},
						  {'1','1','X','1','1'},
						  {'X','1','X','E','1'},
						  {'1','1','1','1','X'}   };
		Point s = new Point(1,1);
		Point e = new Point(3,3);
		int[][] path = new int[N][N];
		obj.find(arr,s,e,path,0);
		obj.findMinimum();
	}
	private void findMinimum() {
		int min = Integer.MAX_VALUE;
		if(minimum[0]==-1){
			System.out.println("No path found");
		}
		else{
			for(int i=0;i<minimum.length;i++){
				if(minimum[i]!=-1&&min>minimum[i]) min=minimum[i];
			}
			System.out.println("min path length is "+min);
		}
	}
}
