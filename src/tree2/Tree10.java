package tree2;

import tree2.Tree10.Node;

/*program to find a minimum level where leaf node is found*/
public class Tree10 {
	static class Node{
		int data;
		Node left;
		Node right;
		Node rightpointer;
		Node(){}
		Node(int n){
			data=n;
			left=null;
			right=null;
		}}
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		root.left.right.left=new Node(9);
		Tree10 obj=new Tree10();
		obj.findrightpointer(root);
		System.out.println(root.left.right.rightpointer.data);

	}
	void findrightpointer(Node root){
		if(root==null) return;
		if(root.left!=null)
			root.left.rightpointer=root.right;
		if(root.right!=null)
			root.right.rightpointer=(root.rightpointer!=null)?root.rightpointer.left:null;
		findrightpointer(root.left);
		findrightpointer(root.right);

	}
}


