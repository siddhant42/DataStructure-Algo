package tree;

public class SumTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(6);
		root.right = new Node(8);
		root.left.left = new Node(-2);
		root.left.right = new Node(3);
		root.right.left = new Node(-6);
		root.right.right = new Node(1);
		root.left.right.left = new Node(-11);
		SumTree obj = new SumTree();
		obj.inOrder(root);;
		obj.convert(root);
		System.out.println();
		obj.inOrder(root);
	}
	private void inOrder(Node root) {
		if(root==null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	private int convert(Node root) {
		if(root==null) return 0;
		//if(root.left==null && root.right==null) return;
		int oldValue = root.data;
		root.data = convert(root.left)+convert(root.right);
		return root.data+oldValue;
	}
}
