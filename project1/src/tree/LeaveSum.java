package tree;

public class LeaveSum {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		/*LeaveSum obj=new LeaveSum();
		obj.findSum(root);
		System.out.println(obj.sum);*/
		System.out.println(new LeaveSum().findSum(root));
	}
	//int sum=0;
	private int findSum(Node root) {
		int sum=0;
		if(root==null) return 0;
		if(root.left!=null&&(root.left.left==null&&root.left.right==null))
			sum+=root.left.data;
		sum+=findSum(root.left)+findSum(root.right);
		return sum;
	}
}
