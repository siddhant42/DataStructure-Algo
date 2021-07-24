package tree;

public class Image {
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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		Node b = new Node(5);
		b.left = new Node(3);
		b.right = new Node(6);
		b.right.left = new Node(5);
		b.right.right = new Node(4);
		System.out.println(new Image().isImage(root,b));
	}
	private boolean isImage(Node a, Node b) {
		if(a==null && b==null) return true;
		if((a!=null && b==null) || (a==null && b!=null))
			return false;
		if(a.left==null&&b.left==null&&a.right==null&&b.right==null){
			if(a.data!=b.data) return false;
		}
		return isImage(a.left,b.right) && isImage(a.right,b.left);
	}
}
