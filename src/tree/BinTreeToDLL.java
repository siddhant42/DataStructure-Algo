package tree;

public class BinTreeToDLL {
	Node head,prev=null;
	static class Node {
		int data;
		Node left,right;
		public Node(int data) {
			super();
			this.data = data;
			left = right = null;
		}
	}
	public void convert(Node root) {
		if(root==null) return;
		convert(root.left);
		if(prev==null) head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convert(root.right);
	}
	public void convert2(Node root) {
		if(root==null) return;
		convert2(root.right);
		root.right = head;
		if(head!=null) head.left = root;
		head = root;
		convert2(root.left);
	}
	public void printList() {
		Node p = head;
		while(p!=null) {
			System.out.print(p.data+" ");
			p = p.right;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinTreeToDLL obj = new BinTreeToDLL();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.left.left.left = new Node(6);
		//root.right.left = new Node(7);
		root.left.right.right = new Node(8);
		//root.right.left.right.right=new Node(9);
		obj.convert2(root);
		obj.printList();
		
	}
}
