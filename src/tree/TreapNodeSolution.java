package tree;

public class TreapNodeSolution {
	public TreapNode merge(TreapNode l, TreapNode r) {
        if (r == null)
            return l;
        else if (l == null)
            return r;
        else if (l.priority < r.priority) {
            r.left = merge(l, r.left);
            update(r);
            return r;
        } else {
            l.right = merge(l.right, r);
            update(l);
            return l;
        }
    }
    public Pair split(TreapNode root, int key,int lcount) {
        if (root == null)
            return new Pair(null, null);
        if ( key >= size(root.left)+1+lcount) {
            Pair pair = split(root.right, key,1+lcount+size(root.left));
            root.right = null;
            TreapNode l = merge(root, pair.left);
            update(l);
            return new Pair(l , pair.right);
        } else {
            Pair pair = split(root.left, key,lcount);
            root.left = null;
            TreapNode r =  merge(pair.right, root);
            update(r);
            return new Pair(pair.left,r);
        }
    }
    int size(TreapNode root){
        if(root!=null){
            return root.size;
        }
        return 0;
    }
    void update(TreapNode root){
        if(root!=null){
            root.size= size(root.left) + 1 + size(root.right);
        }
    }
    int getmin(TreapNode root){
        if(root.left!=null){
            return getmin(root.left);
        }
        return root.key;
    }
    int getmax(TreapNode root){
        if(root.right!=null){
            return getmax(root.right);
        }
        return root.key;
    }
    void inorder(TreapNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
}
