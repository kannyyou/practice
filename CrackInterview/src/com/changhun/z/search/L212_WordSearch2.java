package com.changhun.z.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]

 * @author changhun
 *
 */
public class L212_WordSearch2 {
	public static List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    TrieNode root = buildTrie(words);
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            dfs (board, i, j, root, res);
	        }
	    }
	    return res;
	}
	
	public static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		System.out.println(i + " " + j);

	    char c = board[i][j];
	    if (c == '#' || p.next[c - 'a'] == null) return;
	    p = p.next[c - 'a'];
	    System.out.println("\t * " + c);
	    if (p.word != null) {   // found one
	        res.add(p.word);
	        p.word = null;     // de-duplicate
	    }


	    board[i][j] = '#';
	    if (i > 0) dfs(board, i - 1, j ,p, res); 
	    if (j > 0) dfs(board, i, j - 1, p, res);
	    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
	    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
	    board[i][j] = c;
	    
		System.out.println("\t" + c + " " + res.toString());

	}
	
	public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {

            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;

        }
        return root;
    }
    
	public static class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
        TrieNode(){}

	}
	
	public static void main(String[] args) {
		char[][] board = {  
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}};	
		
		String[] words = {"oath","pea","eat","rain"};
		
		System.out.println(findWords(board, words).toString());
		
		
		
	}
}
