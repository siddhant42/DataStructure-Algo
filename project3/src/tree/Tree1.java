package tree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//program of depth order traversal of a binary tree
public class Tree1 {
	int data;
	Tree1 left;
	Tree1 right;
	Tree1(){}
	Tree1(int n){
		data=n;
		left=null;
		right=null;
	}
	public void traverse(Tree1 root,int dist,TreeMap<Integer,ArrayList<Integer>> hm){
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
	public void dfs(Tree1 root){
		TreeMap<Integer,ArrayList<Integer>> m=new TreeMap<Integer,ArrayList<Integer>>();
		traverse(root,0,m);
		Set<Integer> s=m.keySet();
		for(int i:s){
			ArrayList<Integer> list=m.get(i);
			System.out.println(list);
		}
		//System.out.println(m.entrySet());
	}

	public static void main(String[] args) {
		Tree1 root=new Tree1(1);
		root.left=new Tree1(2);
		root.right=new Tree1(3);
		root.left.left=new Tree1(4);
		root.left.right=new Tree1(5);
		root.right.left=new Tree1(6);
		root.right.right=new Tree1(7);
		root.left.left.right=new Tree1(8);
		root.left.right.right=new Tree1(9);
		Tree1 obj=new Tree1();
		obj.dfs(root);
	}
}
