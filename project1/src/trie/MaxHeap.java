package trie;

public class MaxHeap {
	int size;
	int[] a;
	public MaxHeap( int arrayLength) {
		super();
		this.size=0;
		this.a = new int[arrayLength];
	}
	public void insert(int data) {
		int i = size++, par;
		while(i>0) {
			par = (i-1)/2;
			if(a[par]>data){
				a[i]=data;
				return;
			}
			a[i]=a[par];
			i=par;
		}
		a[0]=data;
	}
	public int getRootNode() {
		return a[0];
	}
	public int deleteTop() {
		int tmp = a[0];
		deleteRootNode();
		return tmp;
	}
	private void deleteRootNode() {
		int i=0;
		a[i]=a[--size];
		int lchild = 2*i+1;
		int rchild = 2*(i+1);
		while(rchild<size) {
			if(a[i]>=a[lchild] && a[i]>=a[rchild]){
				return;
			}
			if(a[lchild]>=a[rchild]) {
				int tmp = a[lchild];
				a[lchild] = a[i];
				a[i] = tmp;
				i=lchild;
			}
			else{
				int tmp = a[rchild];
				a[rchild] = a[i];
				a[i] = tmp;
				i=rchild;
			}
			 lchild = 2*i+1;
			 rchild = 2*(i+1);
		}
		if(lchild==size-1 && a[lchild]>=a[i]) {
			int tmp = a[lchild];
			a[lchild] = a[i];
			a[i] = tmp;
		}
	}
	public int getSize() {
		return size;
	}
	
}
