package tree2;

public class Depth {
	private static int height(Node root){
		if(root==null) return 0;
		Node[] s=new Node[10];
		int max=0,t=0;
		Node p=root;
		while(p!=null){
			s[t++]=root;
			if(max<t) max=t;
			p=p.left;
		}
		t--;
		while(t>=0){
			p=s[t];
			p=p.right;
			while(p!=null){
				s[t++]=p;
				if(max<t) max=t;
				p=p.left;
			}
			t--;
		}
		return max;
	}
	/*static int height(Node root){
		if(root==null) return 0;
		int l=height(root.left);
		int r=height(root.right);
		return 1+((l>r)?l:r);
	}*/
	static class Node{
		int data;
		Node left;
		Node right;
		Node(){}
		Node(int n){
			data=n;
			left=null;
			right=null;
		}}
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.right=new Node(8);
		root.left.right.right=new Node(9);
		System.out.println(height(root));
	}	
}
