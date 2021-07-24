package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private int v;
	private LinkedList<Integer> adj[];
	@SuppressWarnings("unchecked")
	public DFS(int v) {
		super();
		this.v = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}
	// adding an edge for undirected graph
	public void addEdge(int st,int dest) {
		adj[st].add(dest);
		adj[dest].add(st);
	}
	// Depth First traverse from a given vertex
	public void traverse(int s) {
		boolean[] visited = new boolean[v];
		traverse(s,visited);
	}
	// depth first traverse from all the vertices of graph
	public void traverse() {
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++) {
		traverse(i,visited);
		}
		
	}
	// helper method to print the Depth First
	private void traverse(int s,boolean[] visited) {
		if(!visited[s]) {
		System.out.print(s+" ");
		visited[s] = true;
		}
		Iterator<Integer> itr = adj[s].listIterator();
		while(itr.hasNext()) {
			int p = itr.next();
			if(!visited[p]) {
				traverse(p,visited);
			}
		}
	}
	public static void main(String[] args) {
		int v =5;
		DFS obj = new DFS(v);
		obj.addEdge(4, 0);
		obj.addEdge(2, 4);
		obj.addEdge(3, 4);
		obj.addEdge(1, 2);
		//obj.traverse();
		obj.traverse(4);
	}
}
