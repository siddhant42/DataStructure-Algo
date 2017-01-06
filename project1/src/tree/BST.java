package tree;
/**
 * Implementation of Binary Search Tree(BST)
 * Implemented methods are- search,insert & delete
 * Although BST doesn't need to maintain height & size of tree
 * but this class does for understanding better for next tree
 * implementation i.e <b> AVL tree </b>
 * @author kumarsid
 *
 */
public class BST {
	public Node newNode(int key){
		Node tmp = new Node();
		tmp.data = key;
		tmp.size = tmp.ht = 1;
		tmp.left = tmp.right = null;
		return tmp;
	}
	private int height(Node root) {
		if(root == null) return 0;
		return root.ht;
	}
	private int size(Node root) {
		if(root == null) return 0;
		return root.size;
	}
	private int max(int a,int b) {
		return a>b?a:b;
	}
	private Node findRightSuccessor(Node root) {
		if(root == null) return null;
		if(root.left==null) return root;
		return findRightSuccessor(root.left);
	}
	public Node search(Node root,int key){
		if(root==null) return null;
		else if(key<root.data) {
			return search(root.left,key);
		}
		else {
			return search(root.right,key);
		}
	}
	public Node insert(Node root,int key) {
		if(root == null) {
			return newNode(key);
		}
		else if(key<=root.data) {
			root.left = insert(root.left,key);
		}
		else {
			root.right = insert(root.right,key);
		}
		root.ht = 1+ max(height(root.left),height(root.right));
		root.size = 1+ size(root.left) + size(root.right);
		return root;
	}
	public Node deleteNode(Node root,int key){
		if(root == null) return null;
		if(key<root.data) {
			root.left = deleteNode(root.left,key);
		}
		else if(key>root.data) {
			root.right = deleteNode(root.right,key);
		}
		else {
			if(root.left==null) {
//				root.data = root.left.data;
//				root.left = deleteNode(root.left,root.left.data);
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			Node p = findRightSuccessor(root.right);
			root.data = p.data;
			root.right = deleteNode(root.right,p.data);
		}
		if(root!=null){
		root.ht = 1 + max(height(root.left),height(root.right));
		root.size = 1 + size(root.left) + size(root.right);
		}
		return root;
	}
	public void inorder(Node root) {
		if(root==null) return;
		inorder(root.left);
		System.out.println(root.data+" "+root.size+" "+root.ht);
		inorder(root.right);
		}
	public static void main(String[] args) {
		BST obj = new BST();
		Node root = null;
		root = obj.insert(root, 50);
		root = obj.insert(root, 60);
		root = obj.insert(root, 70);
		root = obj.insert(root, 30);
		root = obj.insert(root, 40);
		root = obj.insert(root, 20);
		root = obj.insert(root, 10);
		//obj.inorder(root);
		root = obj.deleteNode(root,20);
		obj.inorder(root);
		
	}
}
