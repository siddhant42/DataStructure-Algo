package tree2;
/*program to find a minimum level where leaf node is found*/
public class Tree7 {
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
	int mindepth(Node root){
		if(root==null) return 0;
		int l=mindepth(root.left);
		int r=mindepth(root.right);
		return 1+((l<r)?l:r);
	}
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		//root.right.left=new Node(6);
		//root.right.right=new Node(7);
		root.left.left.right=new Node(8);
		root.left.right.right=new Node(9);
		Tree7 obj=new Tree7();
		int d=obj.mindepth(root);
		System.out.println(d);

	}
}

