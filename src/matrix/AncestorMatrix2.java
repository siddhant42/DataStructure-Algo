package matrix;

import java.util.Stack;

public class AncestorMatrix2 {
	static int[][] a = new int[100][100];
	static class Node{
		int data;
		Node left,right;
		public Node(int data) {
			super();
			this.data = data;
			left=right = null; 
		}
	}
	public static void print(Node root) {
		if(root==null) return;
		Stack<Integer> s = new Stack<>();
		int n = printNode(root,s);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int printNode(Node root,Stack<Integer> s) {
		if(root==null) return 0;
		for(int i=0;i<s.size();i++) {
			a[s.elementAt(i)][root.data] = 1;
		}
			s.push(root.data);
			int l = printNode(root.left,s);
			int r = printNode(root.right,s);
			s.pop();
			return l+r+1;
		
	}
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(0);
		root.left.right = new Node(4);
		root.right.left = new Node(3);
		print(root);
	}
}
