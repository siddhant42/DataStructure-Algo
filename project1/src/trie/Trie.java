package trie;
class TrieNode {
    TrieNode[] arr;
    boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        this.arr = new TrieNode[26];
    }
 
}
 
public class Trie {
    private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }
 
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null)
                p.arr[index]= new TrieNode();
                p=p.arr[index];
        }
        p.isEnd=true;
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
 
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!=null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
 
        if(p==root)
            return null;
 
        return p;
    }
    public static void main(String[] args) {
   	 Trie trie = new Trie();
   	 trie.insert("cat");
   	 trie.insert("cats");
   	 trie.insert("cats");
   	 trie.insert("up");
   	 trie.insert("cut");
   	 trie.insert("map");
   	 trie.insert("man");
   	 trie.insert("mad");
   	 trie.insert("maze");
   	 
   	 System.out.println(trie.search("cut"));
	}
}