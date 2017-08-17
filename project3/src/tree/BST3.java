package tree;


public class BST3 {
	int data;
	BST3 left;
	BST3 right;

	public BST3() {
		super();
	}
	public BST3(int data) {
		super();
		this.data = data;
		left=right=null;
	}
	public BST3 construct(int[] a,int low,int high){
		if(a==null||a.length==0) return null;
		if(low>high) return null;
		int mid=(low+high)/2;
		BST3 root=new BST3(a[mid]);

		root.left=construct(a,low,mid-1);
		root.right=construct(a,mid+1,high);
		return root;
	}
	private void Inorder(BST3 root){
		if(root==null) return;
		Inorder(root.left);
		System.out.print(root.data+" ");
		Inorder(root.right);
	}
	public static void main(String[] args) {
		BST3 obj=new BST3();
		int a[]={1,2,5,10,12,15,18,20};
		BST3 p=obj.construct(a,0,a.length-1);
		obj.Inorder(p);
	}
}

