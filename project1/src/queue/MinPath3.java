package queue;

import java.util.LinkedList;

public class MinPath3 {
	int N = 3;
	public int findMin(char[][] a,Point s,Point e){
		if(!isValidCell(a,s.x,s.y) || !isValidCell(a,e.x,e.y)) return -1;
		boolean[][] visited = new boolean[N][N];
		LinkedList<Point> queue = new LinkedList<>();
		queue.offer(s);
		int[][] step = new int[N][N];
		visited[s.x][s.y] = true;
		while(!queue.isEmpty()) {
			Point point = queue.pop();
			if(point.equals(e)) return step[point.x][point.y];
			int x=point.x,y = point.y;
			for(int j=y-1;isValidCell(a,x,j);j--){
				if(!visited[x][j]){
					queue.offer(new Point(x,j));
					step[x][j]=step[x][y]+1;
					visited[x][j]=true;
				}
			}
			for(int j=y+1;isValidCell(a,x,j);j++){
				if( !visited[x][j]){
					queue.offer(new Point(x,j));
					step[x][j]=step[x][y]+1;
					visited[x][j]=true;
				}
			}
			for(int j=x-1;isValidCell(a,j,y);j--){
				if(!visited[j][y]){
					queue.offer(new Point(j,y));
					step[j][y]=step[x][y]+1;
					visited[j][y]=true;
				}
			}
			for(int j=x+1;isValidCell(a,j,y);j++){
				if(!visited[j][y]){
					queue.offer(new Point(j,y));
					step[j][y]=step[x][y]+1;
					visited[j][y]=true;
				}
			}
		}
		return -1;
	}
	boolean isValidCell(char[][] a,int x,int y){
		if(x<0||x>=N||y<0||y>=N||a[x][y]=='X')
			return false;
		return true;
	}	
public static void main(String[] args) {
	char[][] a = {{'.','X','.'},
			  {'.','X','.'},
			  {'.','.','.'}};
	Point s = new Point(0,0);
	Point e = new Point(0,2);
	int minLength = new MinPath3().findMin(a,s,e);
	System.out.println(minLength);
}
}
