package tree;

public class FindMinWeight {
	public static void main(String[] args) {
		TreapImpl obj = new TreapImpl();
		TreapNode root = null;
		int[] v = {3,5,6,2,4};
		int[] w = {4,6,5,2,9};
		int d = 8;
		for(int i=0;i<v.length;i++){
			root = obj.insert(root, v[i], w[i], i+1);
		}
		for(int i=0;i<v.length;i++){
			TreapNode tn = obj.search(root,d-v[i] );
			System.out.println(tn.idx);
		}
	}
}
