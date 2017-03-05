package tree;


public class Height {
	static class Node {
		int data;
		Node left,right;
		public Node(int data) {
			super();
			this.data = data;
			left = right = null;
		}
		
	}
	static int height(Node root) {
		return height(root,0);
	}
	static int height(Node root,int h) {
		if(root==null) return h;
		int count = 0;
		count = Math.max(count, Math.max(height(root.left,h+1),height(root.right,h+1)));
		return count;
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.left.left.left = new Node(6);
		//root.right.left = new Node(7);
		root.left.right.right = new Node(8);
		//root.right.left.right.right=new Node(9);
		System.out.println(height(root));
	}
}
