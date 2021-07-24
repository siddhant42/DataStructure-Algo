package tree;

import java.math.BigDecimal;

public class AVLTree {
	public  void preOrder(Node root) {
		if(root==null) return;

		System.out.println(root.data+" "+root.size+" "+root.ht);
		preOrder(root.left);
		preOrder(root.right);
	}
	public  Node insert(Node root,int key) {
		if(root==null) return newNode(key);
		if(key<=root.data)
			root.left = insert(root.left,key);
		else 
			root.right = insert(root.right,key);
		if(root!=null) {
			root.ht = 1 + max(height(root.left),height(root.right));
			root.size = 1 + size(root.left) + size(root.right);
		}
		int balance = getBalance(root);
		if(balance>1 && key<=root.left.data) 
			return rotateRight(root);
		if(balance<-1 && key>=root.right.data)
			return rotateLeft(root);
		if(balance>1 && key>=root.left.data){
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		if(balance<-1 && key<=root.right.data) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		return root;
	}
	public  Node deleteNode(Node root,int key) {
		if(root==null) return null;
		if(key<root.data) {
			root.left = deleteNode(root.left,key);
		}
		else if(key>root.data) {
			root.right = deleteNode(root.right,key);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			Node p = findInorderSuccessor(root.right);
			root.data = p.data;
			root.right = deleteNode(root.right,p.data);
		}
		if(root!=null) {
			root.ht = 1 + max(height(root.left),height(root.right));
			root.size = 1 + size(root.left) + size(root.right);
		}
		int bal = getBalance(root);
		if(bal>1) {
			int leftBal = getBalance(root.left);
			if(leftBal>=0) {
				root = rotateRight(root);
			}
			else {
				root.left = rotateLeft(root.left);
				root = rotateRight(root);
			}
		}
		else if(bal<-1) {
			int rightBal = getBalance(root.right);
			if(rightBal<=0) {
				root = rotateLeft(root);
			}
			else {
				root.right = rotateRight(root.right);
				root = rotateLeft(root);
			}
		}
		return root;
	}
	public  Node search(Node root,int key) {
		if(root == null) return null;
		if(key == root.data) return root;
		else if(key<=root.data) {
			return search(root.left,key);
		}
		else {
			return search(root.right,key);
		}
	}
	public  int size(Node root) {
		if(root==null) return 0;
		return root.size;
	}
	private  Node findInorderSuccessor(Node root) {
		if(root==null || root.left==null) return root;
		return findInorderSuccessor(root.left);
	}
	private  int getBalance(Node root) {
		if(root==null) return 0;
		return height(root.left)-height(root.right);
	}
	private  Node rotateRight(Node root) {
		Node tmp = root.left;
		root.left = tmp.right;
		tmp.right = root;
		root.ht = max(height(root.left),height(root.right))+1;
		root.size = 1 + size(root.left) + size(root.right);
		tmp.ht = max(height(tmp.left),height(tmp.right))+1;
		tmp.size = 1 + size(tmp.left) + size(tmp.right);
		return tmp;
	}
	private  Node rotateLeft(Node root) {
		Node tmp = root.right;
		root.right = tmp.left;
		tmp.left = root;
		root.ht = max(height(root.left),height(root.right))+1;
		root.size = 1 + size(root.left) + size(root.right);
		tmp.ht = max(height(tmp.left),height(tmp.right))+1;
		tmp.size = 1 + size(tmp.left) + size(tmp.right);
		return tmp;
	}
	private  int max(int a, int b) {
		return Math.max(a, b);
	}
	private  Node newNode(int key) {
		Node tmp = new Node();
		tmp.data = key;
		tmp.left = tmp.right = null;
		tmp.ht = 1;
		tmp.size = 1;
		return tmp;
	}
	private  int height(Node root) {
		if(root == null) return 0;
		return root.ht;
	}
	public  void inorder(Node root) {
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.data+" "+root.size+" "+root.ht);
		inorder(root.right);
	}
	public void findMedian(Node root,int lsize,int rsize,int l,int r) {
		int bal = lsize-rsize;
		if(bal==0) {
			System.out.println(root.data);
		}
		else if(bal==1) {
			long med =  (long)root.data+findMax(root.left);
            if(med%2==0)
                System.out.println(med/2);
            else 
                System.out.println(BigDecimal.valueOf((double)med/2));
		}
		else if(bal==-1) {
			long med = (long)root.data+findMin(root.right);
            if(med%2==0)
                System.out.println(med/2);
            else 
                System.out.println(BigDecimal.valueOf((double)med/2));
		}
		else if(bal>1) {
			r = size(root.right)+1+r;
			findMedian(root.left,size(root.left.left)+l,size(root.left.right)+r,l,r);
		}
		else {
			l = size(root.left)+1+l;
	       findMedian(root.right,size(root.right.left)+l,size(root.right.right)+r,l,r);
		}
	}
	private int findMax(Node root) {
		if(root == null) return 0;
		else if(root.right==null) return root.data;
		return findMax(root.right);
	}
	private int findMin(Node root) {
		if(root==null) return 0;
		else if(root.left==null) return root.data;
		return findMin(root.left);
	}
	public static void main(String[] args) {
		AVLTree obj = new AVLTree();
		Node root = null;
		root = obj.insert(root, 3);
		root = obj.insert(root, 2);
		root = obj.insert(root, 4);
		root = obj.insert(root, 5);
		root = obj.insert(root, 6);
//		root = obj.insert(root,70);
//		root = obj.insert(root,10);
//		root = obj.deleteNode(root,70);
		
		//inorder(root);
		obj.preOrder(root);

	}
}
