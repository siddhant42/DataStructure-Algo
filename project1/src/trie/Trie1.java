package trie;



public class Trie1 {
	static class TrieNode {
	    private char val;
	    private TrieNode left, mid, right;
	    private boolean end;
	    
	    // Initialize your data structure here.
	    public TrieNode() {
	        // do nothing
	    }
	    
	    public TrieNode(char val) {
	        this.val = val;
	    }
	}
    private TrieNode root;

    public Trie1() {
        root = null;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word != null && !word.isEmpty()) root = insert(word.toCharArray(), 0, root);
    }
    
    private TrieNode insert(char[] word, int index, TrieNode node) {

    	char ch = word[index];
        if (node == null) node = new TrieNode(ch);
        if (ch < node.val) node.left = insert(word, index, node.left);
        else if (ch > node.val) node.right = insert(word, index, node.right);
        else if (index < word.length - 1) node.mid = insert(word, index + 1, node.mid);
        else node.end = true;
        return node;
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, TrieNode node) {
        if (node == null) return false;
        char ch = word.charAt(index);
        if (ch < node.val) return search(word, index, node.left);
        if (ch > node.val) return search(word, index, node.right);
        if (index < word.length() - 1) return search(word, index + 1, node.mid);
        return node.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        return startsWith(prefix, 0, root);
    }
    
    private boolean startsWith(String prefix, int index, TrieNode node) {
        if (node == null) return false;
        char ch = prefix.charAt(index);
        if (ch < node.val) return startsWith(prefix, index, node.left);
        if (ch > node.val) return startsWith(prefix, index, node.right);
        if (index == prefix.length() - 1) return true;
        return startsWith(prefix, index + 1, node.mid);
    }
    public static void main(String[] args) {
    	 Trie1 trie = new Trie1();
    	 trie.insert("cat");
    	 trie.insert("cats");
    	 //trie.insert("cats");
    	 trie.insert("up");
    	 trie.insert("cut");
    	 trie.insert("map");
    	 trie.insert("man");
    	 trie.insert("mad");
    	 trie.insert("maze");
    	 
    	 System.out.println(trie.search("cat"));
	}
}