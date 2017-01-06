package tree;

public class BST1 {
int data;
BST1 left;
BST1 right;

public BST1() {
	super();
}
public BST1(int data) {
	super();
	this.data = data;
	left=right=null;
}
//BST1 root=null;
public void construct(BST1 root,int[] a){
	if(a==null||a.length==0){
		System.out.println("array is empty");
		return;
	}
	for(int i=0;i<a.length;i++)
		constructRec(root,a[i]);
	Inorder(root);
}
	void constructRec(BST1 root,int n){
		if(root==null) return;
		if(root.left==null && n<root.data) root.left=new BST1(n);
		else if(root.right==null&&n>=root.data) root.right=new BST1(n);
		else{
		if(n<root.data) 
			constructRec(root.left,n);
		else if(n>=root.data)
			constructRec(root.right,n);
	}}
private void Inorder(BST1 root){
	if(root==null) return;
	Inorder(root.left);
	System.out.print(root.data+" ");
	Inorder(root.right);
}
public static void main(String[] args) {
	int a[]={1,2,5,10,12,15,18,20};
	BST1 root=null;
	new BST1().construct(root,a);
}
}
