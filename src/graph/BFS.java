package graph;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * Breadth first traversal(Search) for an undirected graph
 * @author Siddhant Kumar
 *
 */
public class BFS {
	private int v;
	private LinkedList<Integer> adj[];
	@SuppressWarnings("unchecked")
	public BFS(int v) {
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
	// breadth first traverse function for an undirected graph
	public void traverse(int s) {
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[v];
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s+" ");
			Iterator<Integer> itr = adj[s].listIterator();
			while(itr.hasNext()) {
				int p = itr.next();
				if(!visited[p]) {
					visited[p] = true;
					queue.add(p);
				}
			}
		}
	}
	public int height(int s) {
		boolean[] visited = new boolean[v];
		visited[s] = true;
		return height(s,0,visited);
	}
	private int height(int s,int h,boolean[] visited) {
		int count = 0;
		boolean b = false;
		Iterator<Integer> itr = adj[s].listIterator();
		while(itr.hasNext()) {
			int p = itr.next();
			if(!visited[p]) {
				visited[p] = true;
				count = Math.max(count, height(p,h+1,visited));
				b = true;
			}
		}
		if(!b) return h;
		return count;
	}
	public static void main(String[] args) {
		int v =5;
		BFS obj = new BFS(v);
		obj.addEdge(4, 0);
		obj.addEdge(2, 4);
		obj.addEdge(3, 4);
		obj.addEdge(1, 2);
		//obj.traverse(4);
		System.out.println(obj.height(1));
	}
}
