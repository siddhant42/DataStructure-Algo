package tree;
//program of left view of a binary tree
public class Tree3 {
	int data;
	Tree3 left;
	Tree3 right;
	Tree3(){}
	Tree3(int n){
		data=n;
		left=null;
		right=null;
	}
	int leftlevel=0;

	void leftview(Tree3 root,int level){
		if(root==null) return;
		if(leftlevel<level){
			System.out.println(root.data);
			leftlevel=level;
		}

		leftview(root.left,level+1);
		leftview(root.right,level+1);

	}
	public static void main(String[] args) {
		Tree3 root=new Tree3(1);
		root.left=new Tree3(2);
		root.right=new Tree3(3);
		root.left.left=new Tree3(4);
		root.left.right=new Tree3(5);
		root.right.left=new Tree3(6);
		root.right.right=new Tree3(7);
		root.left.left.right=new Tree3(8);
		root.left.right.right=new Tree3(9);
		Tree3 obj=new Tree3();
		obj.leftview(root,1);
	}
}
