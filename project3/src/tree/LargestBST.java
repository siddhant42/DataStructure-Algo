package tree;


public class LargestBST {
	static class Node{
		int data;
		Node left;
		Node right;
		int size;
		Node(){}
		Node(int n){
			data=n;
			left=right=null;
			size = 1;
		}
	}
/*	int size(Node root) {
		if(root==null) return 0;
		return root.size;
	}*/
/*	public Node insert(Node root,int key) {
		if(root==null) return new Node(key);
		if(key<root.data)
		root.left = insert(root.left,key);
		else
		root.right = insert(root.right,key);
		root.size = 1+size(root.left)+size(root.right);
		return root;
	}*/
	int size(Node root) {
		if(root==null) return 0;
		return 1+size(root.left)+size(root.right);
	}
	public Node findMax(Node root) {
		if(root==null) return null;
		root.left = findMax(root.left);
		root.right = findMax(root.right);
		root.size = 1+size(root.left)+size(root.right);
		if((root.left==null||root.data>=root.left.data) 
				&&(root.right==null||root.data<=root.right.data))
			return root;
		else if(root.left==null) return root.right;
		else if(root.right==null) return root.left;
		else if(root.left.size>root.right.size) return root.left;
		else return root.right;
	} 
	public void inorder(Node root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public static void main(String[] args) {
		LargestBST obj = new LargestBST();
		Node root = new Node( 5);
		root.left = new Node( 2);
		root.left.left = new Node( 1);
		root.left.right = new Node( 3);
		root.right = new Node( 4);
		Node p = obj.findMax(root);
		obj.inorder(p);
	}
}
