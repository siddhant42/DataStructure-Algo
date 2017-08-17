package tree;

import tree.BST9.Node;

public class BST9 {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(){}
		Node(int n){
			data=n;
			left=null;
			right=null;
		}
	}
	public static void main(String[] args) {
		Node root=new Node(5);
		root.left=new Node(3);
		root.right=new Node(15);
		root.left.left=new Node(2);
		root.left.right=new Node(4);
		root.right.left=new Node(10);
		root.right.right=new Node(20);
		root.right.right.left=new Node(18);
		BST9 obj=new BST9();
		obj.convert(root);
		obj.printdata(obj.head);
	}
	Node prev=null,head=null;
	void convert(Node root){
		if(root==null) return;
		convert(root.left);
		if(prev==null){
			head=root;

		}
		else{

			prev.right=root;
		}
		prev=root;
		convert(root.right);
	}
	void printdata(Node root){
		if(root==null) return;
		System.out.print(root.data+" ");
		printdata(root.right);
	}
}
