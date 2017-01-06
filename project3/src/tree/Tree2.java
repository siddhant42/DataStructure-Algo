package tree;
//program of levelorder traversal of a binary tree
public class Tree2 {
	int data;
	Tree2 left;
	Tree2 right;
	Tree2(){}
	Tree2(int n){
		data=n;
		left=null;
		right=null;
	}
	int depth(Tree2 root){
		if(root==null) return 0;
		int l,r;
		l=depth(root.left);
		r=depth(root.right);
		return 1+(l>r?l:r);
	}
	void printgivenlevel(Tree2 root,int n){
		if(root==null) return;
		if(n==1)
			System.out.print(root.data+" ");
		else{
			printgivenlevel(root.left,n-1);
			printgivenlevel(root.right,n-1);
		}
	}
	void lorder(Tree2 root){
		if(root==null) return;
		int i,n=depth(root);
		System.out.println(n);
		for(i=1;i<=n;i++){
			printgivenlevel(root,i);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Tree2 root=new Tree2(1);
		root.left=new Tree2(2);
		root.right=new Tree2(3);
		root.left.left=new Tree2(4);
		root.left.right=new Tree2(5);
		root.right.left=new Tree2(6);
		root.right.right=new Tree2(7);
		root.left.left.right=new Tree2(8);
		root.left.right.right=new Tree2(9);
		Tree2 obj=new Tree2();
		obj.lorder(root);
	}
}
