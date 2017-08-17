package tree;
//program of left view of a binary tree
public class LeftView {
	static class Node{
	private int data;
	private Node left;
	private Node right;
	public Node(){}
	public Node(int n){
		data=n;
		left=null;
		right=null;
	}
	}
	int leftlevel=0;

	public void leftview(Node root,int level){
		if(root==null) return;
		if(leftlevel<level){
			System.out.println(root.data);
			leftlevel=level;
		}

		leftview(root.left,level+1);
		leftview(root.right,level+1);

	}
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.right=new Node(8);
		root.left.right.right=new Node(9);
		LeftView obj=new LeftView();
		obj.leftview(root,1);
	}
}
