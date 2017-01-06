package tree;

import tree.Tree7.Node;

public class BST5 {
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
	public static void main(String[] args) {
		/*Node root=new Node(5);
		root.left=new Node(3);
		root.right=new Node(11);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.right.left=new Node(8);
		root.right.right=new Node(15);
		root.right.left.left=new Node(7);
		root.right.left.left.left=new Node(6);
		root.right.left.right=new Node(9);
		root.right.right.left=new Node(20);
		root.right.right.right=new Node(12);*/
		Node root=new Node(15);
		root.left=new Node(8);
		root.right=new Node(17);
		root.left.left=new Node(12);
		root.left.right=new Node(10);
		root.right.left=new Node(13);
		root.right.right=new Node(20);
		root.right.left.right=new Node(18);
		root.left.right.right=new Node(22);
		BST5 obj=new BST5();
		obj.find(root);
		System.out.println(obj.maxnode);
		obj.inorder(obj.largestBST);

	}	
	Node largestBST=null;
	int maxnode;
	int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	int find(Node root){
		if(root==null) return 0;
		boolean isbst=true;
		int leftnode=find(root.left);
		int curr_min=(leftnode==0)?root.data:min;
		//System.out.println("min "+min+" max= "+max);
		if(leftnode==-1||(leftnode!=0&&root.data<=max))
			isbst=false;
		int rightnode=find(root.right);
		int curr_max=(rightnode==0)?root.data:max;
		//System.out.println("max "+max+" min= "+min);
		if(rightnode==-1||(rightnode!=0&&root.data>=min))
			isbst=false;
		if(isbst){
			min=curr_min;
			max=curr_max;
			int totalnode=leftnode+rightnode+1;
			if(maxnode<totalnode) {
				maxnode=totalnode;
				largestBST=root;
			}
			return totalnode;
		}
		else
			return -1;
	}
	void inorder(Node root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
