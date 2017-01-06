package tree;

import tree.Depth.Node;

public class InorderTraversal {
	void inorder2(Node root){
		if(root==null) return;
		Node[] s=new Node[10];
		int top=0;
		Node p=root;
		while(p!=null){
			s[top++]=p;
			//System.out.print(top+" ");
			p=p.left;
		}
		top--;
		while(top>=0){
			//System.out.print(top+" ");
			p=s[top];
			System.out.print(p.data+" ");
			p=p.right;
			while(p!=null){
				s[top++]=p;
				p=p.left;
			}
			top--;
		}
	}
	void inorder(Node root){
		if(root==null) return;
		else{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
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
			InorderTraversal obj=new InorderTraversal();
			obj.inorder(root);
			System.out.println();
			obj.inorder2(root);
		}	

}
