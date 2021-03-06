package trie;

public class TST {
	static class Node {
		int data;
		Node left,mid,right;
		boolean end;
		public Node() {
			super();
		}
		public Node(int data) {
			super();
			this.data = data;
			left=right=mid=null;
			end = false;
		}
	}
	public Node insert(Node root,String str) {
		return insert(root,0,str);
	}
	private Node insert(Node root, int idx, String str) {
		char ch = str.charAt(idx);
		if(root==null) root = new Node(ch);
		if(ch<root.data)	  root.left = insert(root.left,idx,str);
		else if(ch>root.data) root.right = insert(root.right,idx,str);
		else if(idx<str.length()-1) root.mid = insert(root.mid,idx+1,str);
		else root.end = true;
		return root;
	}
	public boolean search(Node root,String str) {
		if(str==null||str.length()==0) return true;
		return search(root,0,str);
	}
	private boolean search(Node root, int idx, String str) {
		if(root==null) return false;
		char ch = str.charAt(idx);
		if(ch<root.data) return search(root.left,idx,str);
		else if(ch>root.data) return search(root.right,idx,str);
		else if(idx<str.length()-1) return search(root.mid,idx+1,str);
		else if(root.data==ch && root.end==true) return true;
		return false;
	}
	public static void main(String[] args) {
		TST trie = new TST();
		Node root = null;
		root = trie.insert(root,"ca");
		root =trie.insert(root,"cat");
		root = trie.insert(root,"catps");
		root = trie.insert(root,"cap");
		root = trie.insert(root,"up");
		root = trie.insert(root,"use");
		root = trie.insert(root,"cut");
		root = trie.insert(root,"cup");
		root = trie.insert(root,"map");
		root = trie.insert(root,"man");
		root = trie.insert(root,"mad");
		root = trie.insert(root,"maze");
	   	 
	   	 System.out.println(trie.search(root,"mant"));
	}
}
