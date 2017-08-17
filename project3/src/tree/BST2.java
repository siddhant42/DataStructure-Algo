package tree;

public class BST2 {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(){}
		Node(int n){
			data=n;
			left=null;
			right=null;
		}
	}
	Node prev=null;
	boolean isBST(Node root){
		if(root==null) return true;
		if(!isBST(root.left)) return false;
		if(prev!=null&&prev.data>root.data)
			return false;
		prev=root;
		return isBST(root.right);

	}
	boolean isBST2(Node root,int min,int max){
		if(root==null) return true;
		if(root.data<min ||root.data>max) return false;
		else
			return isBST2(root.left,min,root.data+1) && isBST2(root.right,root.data+1,max);
	}
	public static void main(String[] args) {
		Node root=new Node(6);
		root.left=new Node(3);
		root.right=new Node(8);
		root.left.left=new Node(1);
		root.left.right=new Node(4);
		root.right.left=new Node(7);
		root.right.right=new Node(9);
		root.left.left.right=new Node(2);
		root.left.right.right=new Node(5);
		BST2 obj=new BST2();
		System.out.println(obj.isBST(root));
		System.out.println(obj.isBST2(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}	
}
