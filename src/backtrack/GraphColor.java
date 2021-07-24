package backtrack;

public class GraphColor {
	public static void main(String[] args) {
		int graph[][] = {{0, 1, 1, 1},
				{1, 0, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 0},
		};
		int m = 3; // Number of colors
		int[] color = new int[graph.length];
		if(new GraphColor().findColors (graph, color,m,0)==false)
			System.out.println("doesn't any solution exists");
	}

	private boolean findColors(int[][] graph, int[] color, int m, int idx) {
		if(idx==color.length){
			for(int c:color)
				System.out.print(c+" ");
			return true;
		}
		for(int i=1;i<=m;i++){
			if(isSafe(graph,color,i,idx)){
				color[idx]=i;
				if(findColors(graph,color,m,idx+1)==true)
					return true;
				else
					color[idx]=0;
			}
		}
		return false;
	}

	private boolean isSafe(int[][] graph, int[] color, int i, int idx) {
		for(int j=0;j<graph[idx].length;j++){
			if(graph[idx][j]==1&&color[j]==i)
				return false;
		}
		return true;
	}
}
