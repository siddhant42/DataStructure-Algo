package tree;

import java.util.Map;
import java.util.TreeMap;

public class BottomView {
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
	public void bottomView(Node root) {
		Map<Integer,Node> map = new TreeMap<>();
		bottomViewRec(root,map,0);
		for(Map.Entry<Integer, Node> entry: map.entrySet()) {
			System.out.print(entry.getValue().data+" ");
		}
	}
	private void bottomViewRec(Node root,Map<Integer,Node> map,int level) {
		if(root==null) return;
		map.put(level, root);
		bottomViewRec(root.left,map,level-1);
		bottomViewRec(root.right,map,level+1);
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
		root.right.left.right.right=new Node(9);
		BottomView obj = new BottomView();
		obj.bottomView(root);
	}
}
