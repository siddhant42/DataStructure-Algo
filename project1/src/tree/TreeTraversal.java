package tree;

import java.util.Stack;

public class TreeTraversal {
	static class Node {
		int data;
		Node left,right;
		public Node() {
			super();
		}
		public Node(int data) {
			super();
			this.data = data;
			this.left=this.right=null;
		}
		
	}
	public static Node newNode(Node root,int key) {
		if(root==null) return new Node(key);
		root.left = newNode(root.left,key);
		root.right = newNode(root.right,key);
		return root;
	}
	public void inorder(Node root) {
		if(root==null) return;
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.empty()) {
			Node p = s.pop();
			System.out.print(p.data+" ");
			if(p.right!=null) {
				p = p.right;
				while(p!=null) {
					s.push(p);
					p = p.left;
				}
			}
		}
	}
	public void inorder2(Node root) {
		if(root == null) return;
		Stack<Node> s= new Stack<>();
		while(root!=null) {
			if(root.right!=null) s.push(root.right);
			System.out.print(root.data+" ");
			root = root.left;
		}
		while(!s.empty()) {
			Node p = s.pop();
			while(p!=null) {
				System.out.print(p.data+" ");
				if(p.right!=null) s.push(p.right);
				p = p.left;
			}
		}
	}
	public void preorder(Node root) {
		if(root==null) return;
		Stack<Node> s = new Stack<>();
		while(root!=null) {
			System.out.print(root.data+" ");
			s.push(root);
			root = root.left;
		}
		while(!s.empty()) {
			Node p = s.pop();
			if(p.right!=null) {
				p = p.right;
				while(p!=null) {
					System.out.print(p.data+" ");
					s.push(p);
					p = p.left;
				}
			}
		}
	}
	public void postorder(Node root) {
		if(root==null) return;
		Stack<Node> s = new Stack<>();
		while(root!=null) {
			s.push(root);
			root = root.left;
		}
		while(!s.empty()) {
			Node p = s.pop();
			while(p.right!=null) {
				s.push(p);
				p = p.right;				
				while(p.left!=null) {
					s.push(p);
					p = p.left;					
				}
			}
			System.out.print(p.data+" ");
		}
	}
	int idx=0;
	public void find(Node root,int[] a) {
		if(root==null) return;
		find(root.left,a);
		a[idx++] = root.data;
		find(root.right,a);
	}
	public int size(Node root) {
		if(root == null) return 0;
		return 1+size(root.left)+size(root.right);
	}
	public static void main(String[] args) {
		TreeTraversal obj = new TreeTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		//obj.inorder(root);
//		obj.postorder(root);
//		System.out.println();
		obj.preorder(root);
	/*	int size = obj.size(root);
		int[] a = new int[size];
		obj.idx=0;
		obj.find(root,a);
		for(int i:a) {
			System.out.print(i+" ");
		}*/
	}
}
