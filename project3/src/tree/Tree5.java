package tree;

//program to convert each level of a binary tree in singly linked list
public class Tree5 {
	int data;
	Tree5 left;
	Tree5 right;
	Tree5(){}
	Tree5(int n){
		data=n;
		left=null;
		right=null;
	}
	int depth(Tree5 root){
		if(root==null) return 0;
		int l=depth(root.left);
		int r=depth(root.right);
		return 1+((l>r)?l:r);
	}
	void printgivenlevel(Tree5 root,int n,boolean b){
		if(root==null) return;
		if(n==1) 
			System.out.print(root.data+" ");
		else if(n>1){
			if(b){
				printgivenlevel(root.left,n-1,b);
				printgivenlevel(root.right,n-1,b);
			}
			else{
				printgivenlevel(root.right,n-1,b);
				printgivenlevel(root.left,n-1,b);
			}
		}
	}
	void printSpiral(Tree5 root){
		if(root==null) return;
		boolean b=true;
		for(int i=1;i<=depth(root);i++){
			printgivenlevel(root,i,b);
			b=!b;
		}
	}
	public static void main(String[] args) {
		Tree5 root=new Tree5(1);
		root.left=new Tree5(2);
		root.right=new Tree5(3);
		root.left.left=new Tree5(4);
		root.left.right=new Tree5(5);
		//root.left.right=new Tree5(5);
		root.right.left=new Tree5(6);
		root.right.right=new Tree5(7);
		root.left.left.right=new Tree5(8);
		root.left.right.right=new Tree5(9);
		Tree5 obj=new Tree5();
		obj.printSpiral(root);

	}
}
