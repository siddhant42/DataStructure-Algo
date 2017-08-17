package tree;

import java.util.LinkedList;
import java.util.Queue;

//program of levelorder traversal of a binary tree
public class BFS {
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
	int depth(Node root){
		if(root==null) return 0;
		int l=depth(root.left);
		int r=depth(root.right);
		return 1+(l>r?l:r);
	}
	void printgivenlevel(Node root,int n){
		if(root==null) return;
		if(n==1)
			System.out.print(root.data+" ");
		else{
			printgivenlevel(root.left,n-1);
			printgivenlevel(root.right,n-1);
		}
	}
	// print level order by using depth of tree
	// TC- O(n-square),SC-O(1)
	public void lorder(Node root){
		if(root==null) return;
		int i,n=depth(root);
		for(i=1;i<=n;i++){
			printgivenlevel(root,i);
			System.out.println();
		}
	}
	// print level order by using queue
	// TC- O(n),SC-O(n)
	public void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node p = q.poll();
			System.out.print(p.data+" ");
			if(p.left!=null)
				q.add(p.left);
			if(p.right!=null)
				q.add(p.right);
		}
	}
	// print level order line by line by using queue
	// TC- O(n),SC-O(n)
	public void levelOrder2(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(true) {
			int size = q.size();
			if(size==0) break;
			while(size>0) {
				Node p = q.poll();
				System.out.print(p.data+" ");
				if(p.left!=null)
					q.add(p.left);
				if(p.right!=null)
					q.add(p.right);
				size--;
			}
			System.out.println();
		}
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
		BFS obj=new BFS();
		obj.levelOrder2(root);
	}
}
