package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class ConnectedGraphCount {
	private int v;
	private LinkedList<Integer> adj[];
	@SuppressWarnings("unchecked")
	public ConnectedGraphCount(int size) {
		this.v = size;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<>();
	}
	public void addEdge(int sIdx,int dIdx) {
		adj[sIdx].add(dIdx);
		adj[dIdx].add(sIdx);
	}
	public int dfsCount() {
		int count = 0;
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfsCountRec(i,visited);
				count++;
			}
		}
		return count;
	}
	private void dfsCountRec(int s,boolean[] visited) {
		Iterator<Integer> itr = adj[s].listIterator();
		while(itr.hasNext()) {
			int p = itr.next();
			if(!visited[p]) {
				visited[p] = true;
				dfsCountRec(p,visited);
			}
		}
	}
	public static void main(String[] args) {
		int a[][]=  new int[][] {
			{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
           };
          ConnectedGraphCount head = new ConnectedGraphCount(a.length);
          for(int i=0;i<a.length;i++) {
        	  for(int j=0;j<a[0].length;j++) {
        		  if(a[i][j]==1)
        		  head.addEdge(i, j);
        	  }
          }
          System.out.println(head.dfsCount());
	}
}
