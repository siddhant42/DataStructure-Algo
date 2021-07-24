package tree;

public class Level {
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
		root.left.right.left = new Node(6);
		root.right.left = new Node(7);
		root.right.left.right = new Node(8);
		Level obj = new Level();
		for(int i=1;i<10;i++){
			System.out.println(obj.findLevel(root,i,1));
		}
}
	private int findLevel(Node root,int data,int level) {
		if(root==null) return 0;
		if(root.data==data) return level;
		int dl = findLevel(root.left,data,level+1);
		if(dl!=0) return dl;
		return findLevel(root.right,data,level+1);
	}
}
