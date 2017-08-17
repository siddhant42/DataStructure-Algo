package tree;


/*program to find common ancestor of a binary tree*/
public class LCA2 {
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
	Node findLca(Node root,Node p1,Node p2){
		if(root==null) return null;
		if(root==p1||root==p2)
			return root;
		Node l=findLca(root.left,p1,p2);
		Node r=findLca(root.right,p1,p2);
		if(l!=null && r!=null) return root;
		if(l==null) return r;
		else return l;
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
		LCA2 obj=new LCA2();
		Node p1=root.left.left.right;
		Node p2=root.left.right.right;
		Node lca=obj.findLca(root,p1,p2);
		System.out.println(lca.data);
	}
}


