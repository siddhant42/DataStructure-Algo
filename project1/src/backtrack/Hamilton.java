package backtrack;

import java.util.Arrays;

public class Hamilton {
	public static void main(String[] args) {
		Hamilton obj = new Hamilton();
		int graph1[][] = {{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 1},
				{0, 1, 1, 1, 0},
		};
		int[] path = new int[graph1.length+1];
		Arrays.fill(path, -1);
		path[0]=0;
		// Print the solution
		if(obj.findPath(graph1,path,0,false,1)==false)
			System.out.println("solution doesn't exist");
		System.out.println();
		int graph2[][] = {{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 0},
				{0, 1, 1, 0, 0},
		};
		Arrays.fill(path, -1);
		path[0]=0;		
		// Print the solution
		if(obj.findPath(graph2,path,0,false,1)==false)
			System.out.println("solution doesn't exist");
	}

	private boolean findPath(int[][] graph,int[] path,int st,boolean b,int idx) {
		if(b==true && st==0){
			for(int p:path)
				System.out.print(p+" ");
			return true;
		}
		for(int i=0;i<graph[st].length;i++) {
			if(graph[st][i]==1 && isSafe(path,i,idx,graph.length)) {
				path[idx]=i;
				if(findPath(graph,path,i,true,idx+1)==true)
					return true;
				path[idx]=-1;
			}
		}
		return false;
	}

	private boolean isSafe(int[] path, int st, int idx,int n) {
		if(idx==n && st==0)
			return true;
		for(int i=0;i<idx;i++) {
			if(path[i]==st)
				return false;
		}
		return true;
	}
}
