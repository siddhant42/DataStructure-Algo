package tree;


public class InorderSuccessorImpl {
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
	public Node findInorderSuccessor(Node root,Node p) {
		return findRec(root,p,null);
	}
	private Node findRec(Node root, Node p, Node parent) {
		if(root==null) return null;
		if(root==p) {
			if(root.right!=null)
				return leftMostNode(root.right);
			else 
				return parent;
		}
		else {
			Node left = findRec(root.left,p,root);
			if(left!=null) return left;
			return findRec(root.right,p,parent);
		}
	}
	private Node leftMostNode(Node root) {
		if(root==null) return null;
		while(root.left!=null)
			root = root.left;
		return root;
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.right.left = new Node(7);
		root.right.left.right = new Node(8);
		root.right.left.right.right=new Node(9);
		InorderSuccessorImpl obj = new InorderSuccessorImpl();
		Node p =obj.findInorderSuccessor(root, root.left.right.left);
		System.out.println(root.left.right.left.data+" has successor data as "+p.data);

	}
}
