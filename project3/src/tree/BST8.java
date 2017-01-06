package tree;

public class BST8 {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(){}
		Node(int n){
			data=n;
			left=null;
			right=null;
		}}
	Node largestBST=null,child=null;
	int maxnode;
	
	int find(Node root,int min,int max){
		if(root==null) return 0;
		
			if(root.data>min&&root.data<max){
				int leftnode=find(root.left,min,root.data);
				Node leftchild=(leftnode==0)?null:child;
				int rightnode=find(root.right,root.data,max);
				Node rightchild=(rightnode==0)?null:child;
				Node parent=new Node(root.data);
				parent.left=leftchild;
				parent.right=rightchild;
				child=parent;
			int totalnode=leftnode+rightnode+1;
			if(maxnode<totalnode) {
				maxnode=totalnode;
				largestBST=parent;
			}
			return totalnode;
		}
		else
		return 0;
	}
	public static void main(String[] args) {
		Node root=new Node(5);
		root.left=new Node(3);
		root.right=new Node(11);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.right.left=new Node(8);
		root.right.right=new Node(15);
		root.right.left.left=new Node(7);
		root.right.left.right=new Node(9);
		root.right.right.left=new Node(20);
		root.right.right.right=new Node(12);
		BST8 obj=new BST8();
		//obj.child=root;
		int min=Integer.MIN_VALUE,max=Integer.MAX_VALUE;
		obj.find(root,min,max);
		System.out.println(obj.maxnode);
		obj.inorder(obj.largestBST);
	
	}	
	
	void inorder(Node root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
