package Q17_17_Multi_Search;

import java.util.ArrayList;

public class Trie {
	private TrieNode root = new TrieNode();
	
	public ArrayList<Integer> search(String s) {
		return root.search(s);
	}
	
	public void insertString(String str, int location) {
		root.insertString(str, location);
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	public String toString() {
		String out = "";
//		while (root != null) {
//			out += root.
//		}
		return root.toString();
	}
	
	public static Trie createTrieFromString(String s) {
		Trie trie = new Trie();
		for (int i = 0; i < s.length(); i++) {
	    	String suffix = s.substring(i);
	    	
	    	trie.insertString(suffix, i);
		}
		return trie;
	}
	
	public static void main(String[] args) {
		String big = "mississippi";
        Trie tree = createTrieFromString(big);
        
        System.out.println(tree.toString());
        System.out.println(tree.search("i"));
	}
}
