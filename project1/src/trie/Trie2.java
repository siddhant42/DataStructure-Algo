package trie;
class Node {
	Node children[];
	boolean isLeaf;
	public Node(){
		this.children = new Node[26];
	}
}
public class Trie2 {
	Node root;
	public Trie2(){
		root = new Node();
	}

	public Node getNode(){
		Node tmp = new Node();
		tmp.isLeaf = false;
		return tmp;
	}
	public void insert(String word) {
		Node p = root;
		char[] key = word.toCharArray();
		for(int i=0;i<key.length;i++) {
			//Node tmp = p.children[key[i]-'a'];
			if( p.children[key[i]-'a']==null)
				 p.children[key[i]-'a'] = getNode();
			p =  p.children[key[i]-'a'];
		}
		p.isLeaf = true;
	}
	public boolean search(String word) {
		Node p = root;
		char[] key = word.toCharArray();
		for(int i=0;i<key.length;i++){
			if( p.children[key[i]-'a']==null)
				 return false;
			p =  p.children[key[i]-'a'];
		}
		return (p!=null && p.isLeaf==true);
	}
	public int countString(String word) {
		if(root==null||word==null) return 0;
		Node p = root;
		char[] key = word.toCharArray();
		for(int i=0;i<key.length;i++){
			if( p.children[key[i]-'a']==null)
				 return 0;
			p =  p.children[key[i]-'a'];
		}
		if(p.isLeaf==true)
			return 1+countRec(p);
		return countRec(p);
	}
	private int countRec(Node root) {
		int count = 0;
		if(root==null) return 0;
		//if(root.isLeaf==true) return 1;
		for(int i=0;i<26;i++){
			if(root.children[i]!=null && root.children[i].isLeaf==true)
				count=1+count+countRec(root.children[i]);
			else
				count += countRec(root.children[i]);
		}
		return count;
	}
	public static void main(String[] args) {
   	 Trie2 trie = new Trie2();
   	 trie.insert("ca");
	 trie.insert("cat");
	 trie.insert("catps");
	 trie.insert("cap");
	 trie.insert("up");
	 trie.insert("use");
	 trie.insert("cut");
	 trie.insert("cup");
	 trie.insert("map");
	 trie.insert("man");
	 trie.insert("mad");
	 trie.insert("maze");
   	 
   	 System.out.println(trie.search("catps"));
   	 System.out.println(trie.countString("ca"));
	}
}

