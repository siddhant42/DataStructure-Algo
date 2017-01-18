package tree;

import tree.TopView.Node;

public class Diameter {
	class Height{
		int h;
	}
	static class Node {
		int data;
		Node left,right;
		public Node(int data) {
			super();
			this.data = data;
			left = right = null;
		}
		
	}
	int diameter(Node root) {
		Height h = new Height();
		return diameter(root,h);
	}
	private int diameter(Node root, Height height) {
		if(root==null){
			height.h=0;
			return 0;
		}
		Height lh = new Height();
		Height rh = new Height();
		int ld = diameter(root.left,lh);
		int rd = diameter(root.right,rh);
		height.h = 1+Math.max(lh.h,rh.h);
		return Math.max(1+lh.h+rh.h, Math.max(ld, rd));
	}
	public static void main(String[] args) {
		Diameter obj = new Diameter();
		Node root = new Node(1);
		root.left = new Node(2);
		//root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(6);
		//root.right.left = new Node(7);
		root.left.right.right = new Node(8);
		//root.right.left.right.right=new Node(9);
		int d = obj.diameter(root);
		System.out.println(d);
	}
}
