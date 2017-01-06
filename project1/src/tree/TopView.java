package tree;

import java.util.HashMap;
import java.util.Map;

import tree.Level.Node;

public class TopView {
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
		root.right.left.right.right=new Node(9);
		TopView obj = new TopView();
		obj.top_view(root);
		
	}
	void top_view(Node root)
	{
		if(root==null) return;
		Map<Integer,Node> map = new HashMap<>();
		leftView(root.left,0,map);
		for(int i=map.size()-1;i>=0;i--)
			System.out.print(map.get(i).data+" ");
		System.out.print(root.data+" ");
		map.clear();
		rightView(root.right,0,map);
		for(int i=0;i<map.size();i++)
			System.out.print(map.get(i).data+" ");
	}
	void leftView(Node root,int count,Map<Integer,Node> map) {
		if(root==null) return;
		if(map.get(count)==null && count>=0)
			map.put(count,root);
		leftView(root.left,count+1,map);
		leftView(root.right,count-1,map);
	}
	void rightView(Node root,int count,Map<Integer,Node> map){
		if(root==null) return;
		if(map.get(count)==null && count>=0)
			map.put(count,root);
		rightView(root.right,count+1,map);
		rightView(root.left,count-1,map);
	}
}
