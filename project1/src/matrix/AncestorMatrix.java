package matrix;

public class AncestorMatrix {
	static class Node{
		int data;
		Node left,right;
		public Node(int data) {
			super();
			this.data = data;
			left=right = null; 
		}
	}
	public static void print(Node root,Node par,int[][] a) {
		if(root==null || (root.left==null && root.right==null)) return;
		par=root;
		print(root.left,par,a);
		print(root.right,par,a);
		if(par!=null ){
			printNode(root.left,par,a);
			printNode(root.right,par,a);
		}
	}
	public static void printNode(Node root,Node par,int[][] a) {
		if(root==null) return;
		printNode(root.left,par,a);
		printNode(root.right,par,a);
		a[par.data][root.data] = 1;
	}
	public static void printArray(int[][] a) {
		if(a==null || a.length==0) return;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(0);
		root.left.right = new Node(4);
		root.right.left = new Node(3);
		int n = 6;
		int[][] a = new int[n][n];
		print(root,null,a);
		printArray(a);
	}
}
