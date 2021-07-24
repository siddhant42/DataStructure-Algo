package tree2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
//program of depth order traversal of a binary tree
public class DFS {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		Node(){}
		Node(int n){
			data=n;
			left=null;
			right=null;
		}
	}
	public void traverse(Node root,int dist,TreeMap<Integer,ArrayList<Integer>> hm){
		if(root==null) return;
		if(hm.get(dist)==null){
			ArrayList<Integer> list=new ArrayList<Integer>();
			list.add(root.data);
			hm.put(dist,list);
		}
		else
			hm.get(dist).add(root.data);
		traverse(root.left,dist-1,hm);
		traverse(root.right,dist+1,hm);
	}
	public void dfs(Node root){
		TreeMap<Integer,ArrayList<Integer>> m=new TreeMap<Integer,ArrayList<Integer>>();
		traverse(root,0,m);
		Set<Map.Entry<Integer,ArrayList<Integer>>> s=m.entrySet();
		for(Map.Entry<Integer, ArrayList<Integer>> entry:s){
			ArrayList<Integer> list=entry.getValue();
			list.stream().map(i-> String.valueOf(i+" ")).forEach(System.out::print);
			System.out.println();
		}
		//System.out.println(m.entrySet());
	}

	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.right=new Node(8);
		root.left.right.right=new Node(9);
		DFS obj=new DFS();
		obj.dfs(root);
	}
}
