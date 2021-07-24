package array2;

import tree.AVLTree;
import tree.Node;

public class MaxProduct {
	public int findMax(int[] arr) {
		if(arr==null || arr.length<3) return 0;
		int n = arr.length;
		int[] lsl = new int[n];
		int[] rsl = new int[n];
		lsl[0] = arr[0];
		AVLTree obj = new AVLTree();
		Node root = null;
		root = obj.insert(root, arr[0]);
		for(int i=1;i<n-1;i++) {
			root = obj.insert(root, arr[i]);
			Node succ = inorderPred(root,arr[i]);
			if(succ!=null) lsl[i] = succ.data;
			else lsl[i] = 0;
		}
		int max = arr[n-1],maxProd = 0;
		for(int i=n-2;i>=0;i--) {
			if(arr[i]<max) rsl[i] = max;
			else max = arr[i];
		}
		for(int i=1;i<n-1;i++) {
			int prod = arr[i]*lsl[i]*rsl[i];
			if(maxProd<prod) maxProd = prod;
		}
		return maxProd;
	}
	Node inorderPred(Node root,int key) {
		if(root == null ) return null;
		Node pred = null;
		while(root!=null && root.data!=key) {
			if(key>root.data) {
				pred = root;
				root = root.right;
			}
			else root = root.left;
		}
		if(root.left!=null) return root.left;
		return pred;
	}
	public static void main(String[] args) {
		MaxProduct obj = new MaxProduct();
		// int arr[] = {6, 7, 8, 1, 2, 3, 9, 10};
		int[] arr = {4,5,50,6,7};
		int d = obj.findMax(arr);
		System.out.println(d);
	}
}
