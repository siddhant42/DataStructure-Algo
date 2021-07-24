package tree;
/**
 * Treap implementation 
 * insert & delete method are general with addition parameters
 * maintains as size & index for custom implementation
 * also custom search method
 * @author kumarsid
 *
 */
public class TreapImpl {
	public TreapNode insert(TreapNode root,int key,int prio,int idx) {
		if(root==null) return newNode(key,prio,idx);
		else if(key<=root.key) {
			root.left = insert(root.left,key,prio,idx);
			if(root.priority > root.left.priority) {
				root = rotateRight(root);
			}
		}
		else {
			root.right = insert(root.right,key,prio,idx);
			if(root.priority > root.right.priority) {
				root = rotateLeft(root);
			}
		}
		if(root!=null) {
			root.size = 1 + size(root.left) + size(root.right);
		}
		return root;
	}
	public TreapNode deleteNode(TreapNode root,int key) {
		if(root == null) return root;
		else if(key<root.key){
			root.left = deleteNode(root.left,key);
		}
		else if(key>root.key) {
			root.right = deleteNode(root.right,key);
		}
		else {
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else if(root.left.priority < root.right.priority) {
				root = rotateRight(root);
				root.right = deleteNode(root.right,key);
			}
			else {
				root = rotateLeft(root);
				root.left = deleteNode(root.left,key);
			}
		}
		if(root!=null) {
			root.size = 1 + size(root.left) + size(root.right);
		}
		return root;
	}
	
	public TreapNode rotateRight(TreapNode root){
		TreapNode p1 = root.left;
		TreapNode p2 = p1.right;
		p1.right = root;
		root.left = p2;
		root.size = 1+size(root.left) + size(root.right);
		p1.size = 1+ size(root.left) + size(root.right);
		return p1;
	}
	public TreapNode rotateLeft(TreapNode root) {
		TreapNode p1 = root.right;
		TreapNode p2 = p1.left;
		p1.left = root;
		root.right = p2;
		root.size = 1+size(root.left) + size(root.right);
		p1.size = 1+ size(root.left) + size(root.right);
		return p1;		
	}
	public TreapNode newNode(int key,int prio,int idx) {
		TreapNode tmp = new TreapNode(key,prio);
		tmp.idx=idx;
		return tmp;
	}
	private int size(TreapNode root) {
		if(root==null) return 0;
		return root.size;
	}
	public TreapNode search(TreapNode root,int key) {
		if(root==null) return null;
		if(key<=root.key) return root;
		else return search(root.right,key);
	}
}
