package tree;

public class TreapNode
{
    TreapNode left, right;
    int priority, key, size, idx;
    public TreapNode(int key, int priority)
    {
        this.key = key;
        this.priority = priority;
        this.size = 1;
    }
	public TreapNode(int key) {
		this.key = key;
		this.priority = (int)(Math.random()*100);
		 this.size = 1;
	}
}

class Pair
{
    TreapNode left, right;
    
    public Pair() {
	}

	Pair(TreapNode left, TreapNode right)
    {
        this.left = left;
        this.right = right;
    }
}