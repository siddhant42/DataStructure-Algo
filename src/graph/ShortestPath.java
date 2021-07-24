package graph;

public class ShortestPath {
	public static final int V = 9;
	private int findMinIndex(int[] dist,boolean[] visited) {
		int min = Integer.MAX_VALUE,idx = -1;
		for(int v=0;v<V;v++) {
			if(!visited[v] && dist[v]<min) {
				min = dist[v];
				idx = v;
			}
		}
		return idx;
	}
	public int[] find(int[][] graph,int source) {
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		dist[source] = 0;
		for(int i=0;i<V-1;i++) {
			int u = findMinIndex(dist,visited);
			visited[u] = true;
			for(int v=0;v<V;v++) {
				if(!visited[v] && graph[u][v]!=0 && 
						dist[u]!=Integer.MAX_VALUE && (dist[u]+graph[u][v])<dist[v])
					dist[v] = dist[u]+graph[u][v];
			}
		}
		return dist;
	}
	public static void main(String[] args) {
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
				{4, 0, 8, 0, 0, 0, 0, 11, 0},
				{0, 8, 0, 7, 0, 4, 0, 0, 2},
				{0, 0, 7, 0, 9, 14, 0, 0, 0},
				{0, 0, 0, 9, 0, 10, 0, 0, 0},
				{0, 0, 4, 14, 10, 0, 2, 0, 0},
				{0, 0, 0, 0, 0, 2, 0, 1, 6},
				{8, 11, 0, 0, 0, 0, 1, 0, 7},
				{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		ShortestPath obj = new ShortestPath();
		int source = 0;
		int[] dist = obj.find(graph, source);
		for(int i=0;i<V;i++) {
			System.out.println("Min distance of "+i+" from source "+source+" is "+dist[i]);
		}
	}
}
