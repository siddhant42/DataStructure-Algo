package queue;

import java.util.LinkedList;
class QueueNode{
	Point pt;
	int idx;
	public QueueNode(Point pt, int idx) {
		super();
		this.pt = pt;
		this.idx = idx;
	}
}
public class MinPath2 {
	private static final int N=5;
	public int FindMin(char[][] a,Point s,Point e){
		LinkedList<QueueNode> queue = new LinkedList<>();
		queue.offer(new QueueNode(s,0));
		int[] row={-1,0,0,1};
		int[] col={0,-1,1,0};
		boolean[][] visited = new boolean[N][N];
		visited[s.x][s.y]=true;
		while(!queue.isEmpty()){
			QueueNode qn = queue.peek();
			Point point = qn.pt;
			queue.poll();
			if(point.equals(e)) return qn.idx;
			int x = point.x;
			int y = point.y;
			for(int i=0;i<4;i++){
				int p = x+row[i];
				int q = y+col[i];
				if(isValidCell(a,p,q) && !visited[p][q]
						){
					visited[p][q]= true;
					queue.offer(new QueueNode(new Point(p,q),qn.idx+1));
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
/*		char[][] a = {{'.','X','.'},
					  {'.','X','.'},
					  {'.','.','.'}};
		Point s = new Point(0,0);
		Point e = new Point(0,2);*/
		char a[][]={    {'1','1','1','1','1'},
				  {'1','S','X','1','1'},
				  {'1','1','X','1','1'},
				  {'X','1','X','E','1'},
				  {'1','1','1','1','X'}   };
		Point s = new Point(1,1);
		Point e = new Point(3,3);
		int minLength = new MinPath2().FindMin(a, s, e);
		System.out.println(minLength);
	}
}
