package tree;

import java.util.ArrayList;
import java.util.Collections;

/*program to find common ancestor of a binary tree*/
public class LCA {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int n){
			data=n;
			left=null;
			right=null;
		}
	}

	Node findLca(Node root,Node p1,Node p2){
		if(root==null) return null;
		if(root==p1||root==p2)
			return root;
		Node l=findLca(root.left,p1,p2);
		Node r=findLca(root.right,p1,p2);
		if(l!=null && r!=null) return root;
		if(l==null) return r;
		else return l;
	}
	boolean printpath(Node root,Node p1,Node p2,ArrayList<Integer> Path){
		if(root==null) return false;
		if(root==p1||root==p2) {
			Path.add(root.data);
			return true;
		}
		boolean left_check=printpath(root.left,p1,p2,Path);
		boolean right_check=printpath(root.right,p1,p2,Path);
		if(left_check||right_check){
			Path.add(root.data);
			return true;
		}
		return true;
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
		LCA obj=new LCA();
		Node p1=root.left.left.right;
		Node p2=root.left.right.right;
		ArrayList<Integer> Path=new ArrayList<Integer>();
		ArrayList<Integer> rightPath=new ArrayList<Integer>();
		Node lca=obj.findLca(root,p1,p2);
		obj.printpath(lca.left,p1,p2,Path);
		//Collections.reverse(obj.Path);
		//obj.Path.add(lca.data);
		obj.printpath(lca.right,p1,p2,rightPath);
		Collections.reverse(rightPath);
		Path.add(lca.data);
		Path.addAll(rightPath);
		System.out.println(Path);
	}
}

