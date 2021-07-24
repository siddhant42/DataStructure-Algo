package tree2;
class Node{
	int data;
	Node next;
	public Node(int data) {
		super();
		this.data = data;
		next=null;
	}

}
public class BST4 {
	int data;
	BST4 left;
	BST4 right;

	public BST4() {
		super();
	}
	public BST4(int data) {
		super();
		this.data = data;
		left=right=null;
	}
	BST4 construct(Node head,int low,int high){
		if(low>high) return null;
		Node p=head;
		int mid=(low+high)/2;
		for(int i=0;i<mid;i++)
			p=p.next;
		BST4 root=new BST4(p.data);
		root.left=construct(head,low,mid-1);
		root.right=construct(head,mid+1,high);
		return root;
	}
	void inorder(BST4 root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public static void main(String[] args) {
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head.next.next.next.next.next=new Node(6);
		BST4 obj=new BST4();
		BST4 p=obj.construct(head,0,5);
		obj.inorder(p);
	}
}
