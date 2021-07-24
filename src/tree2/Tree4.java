package tree2;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

//program to convert each level of a binary tree in singly linked list
public class Tree4 {
	int data;
	Tree4 left;
	Tree4 right;
	Tree4(){}
	Tree4(int n){
		data=n;
		left=null;
		right=null;
	}
	void convert(Tree4 root,int level){
		TreeMap<Integer,LinkedList<Integer>> tm=new TreeMap<Integer,LinkedList<Integer>>();
		leftview(root,level,tm);
		Set<Integer> s=tm.keySet();
		for(int i:s){
			LinkedList<Integer> ll=tm.get(i);
			System.out.println(ll);
		}
	}
	void leftview(Tree4 root,int level,TreeMap<Integer,LinkedList<Integer>> tm){
		if(root==null) return;
		if(tm.get(level)==null){
			LinkedList<Integer> ll=new LinkedList<Integer>();
			ll.add(root.data);
			tm.put(level,ll);}
		else{
			tm.get(level).add(root.data);

		}

		leftview(root.left,level+1,tm);
		leftview(root.right,level+1,tm);

	}
	public static void main(String[] args) {
		Tree4 root=new Tree4(1);
		root.left=new Tree4(2);
		root.right=new Tree4(3);
		root.left.left=new Tree4(4);
		root.left.right=new Tree4(5);
		//root.left.right=new Tree4(5);
		root.right.left=new Tree4(6);
		root.right.right=new Tree4(7);
		root.left.left.right=new Tree4(8);
		root.left.right.right=new Tree4(9);
		Tree4 obj=new Tree4();
		obj.convert(root,1);

	}
}
