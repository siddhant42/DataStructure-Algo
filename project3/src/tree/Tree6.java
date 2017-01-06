package tree;

//program to convert each level of a binary tree in singly linked list
public class Tree6 {
	int data;
	Tree6 left;
	Tree6 right;
	Tree6(){}
	Tree6(int n){
		data=n;
		left=null;
		right=null;
	}
	int r=0;
	int depth(Tree6 root){
		if(root==null) return 0;
		int l=depth(root.left);
		int r=depth(root.right);
		return 1+((l>r)?l:r);
	}
	void printrightview(Tree6 root,int n,int max){
		if(root==null||n==(max+1)) return;
		if(r<n){
			System.out.println(root.data+" ");
			r=n;
		}

		printrightview(root.right,n+1,max);
		printrightview(root.left,n+1,max);


	}
	public static void main(String[] args) {
		Tree6 root=new Tree6(1);
		root.left=new Tree6(2);
		root.right=new Tree6(3);
		root.left.left=new Tree6(4);
		root.left.right=new Tree6(5);
		root.right.left=new Tree6(6);
		root.right.right=new Tree6(7);
		root.left.left.right=new Tree6(8);
		root.left.right.right=new Tree6(9);
		Tree6 obj=new Tree6();
		int d=obj.depth(root);
		obj.printrightview(root,1,d);

	}
}

