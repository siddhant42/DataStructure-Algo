package tree;

public class Treap {
    private TreapNode root;

    public boolean search(int key)
    {
        return search(root, key);
    }

    private boolean search(TreapNode treap, int key)
    {
        while(treap!=null)
        {
            if (treap.key > key)
                treap=treap.left;
            else if (treap.key < key)
                treap=treap.right;
            else return true;
        }
        return false;
    }

    private TreapNode merge(TreapNode l, TreapNode r) {
        if (r == null)
            return l;
        else if (l == null)
            return r;
        else if (l.priority < r.priority) {
            r.left = merge(l, r.left);
            return r;
        } else {
            l.right = merge(l.right, r);
            return l;
        }
    }

    public void insert(int key, int priority)
    {
        TreapNode temp = root;
        while (temp != null && temp.key != key)
            if (key < temp.key)
                temp = temp.left;
            else
                temp = temp.right;
        if (temp == null) {
            TreapNode m = new TreapNode(key,priority);
            Pair p = split(root, key, priority);
            root = merge(p.left, merge(m, p.right));
        }
    }

    private Pair split(TreapNode root, int key, int priority) {
        if (root == null)
            return new Pair(null, null);
        if ( key > root.key) {
            Pair pair = split(root.right, key, priority);
            root.right = null;
            return new Pair(merge(root, pair.left), pair.right);
        } else {
            Pair pair = split(root.left, key, priority);
            root.left = null;
            return new Pair(pair.left, merge(pair.right, root));
        }
    }

    private void bypass(TreapNode t)
    {
        if(t!=null)
        {
            bypass(t.left);
            System.out.print(t.key+" ");
            bypass(t.right);
        }
    }

    public void print()
    {
        print(root, 0);
    }

    public void bypass()
    {
        bypass(root);
    }

    private void print(TreapNode t, int level)
    {
        if(t!=null)
        {
            print(t.left, level+1);
            for(int i=0; i<level; i++)
                System.out.print("...");
            System.out.println(t.key);
            print(t.right,level+1);
        }
    }
}