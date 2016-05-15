/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
*/

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, new String(), result, trie);
            }
        }
        return new ArrayList<String>(result);
    }
    
    private void dfs(char[][] board, int i, int j, String word, Set<String> result, Trie trie) {
        if (!trie.isPrefix(word) || board[i][j] == '*') {
            return;
        }
        word += board[i][j];
        if (trie.isWord(word)) {
            result.add(word);
        }
        char temp = board[i][j];
        board[i][j] = '*';
        if (i - 1 >= 0) {
            dfs(board, i - 1, j, word, result, trie);
        }
        if (i + 1 <= board.length - 1) {
            dfs(board, i + 1, j, word, result, trie);
        }
        if (j - 1 >= 0) {
            dfs(board, i, j - 1, word, result, trie);
        }
        if (j + 1 <= board[0].length - 1) {
            dfs(board, i, j + 1, word, result, trie);
        }
        board[i][j] = temp;
    }
    
    private class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        boolean isPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }
        
        boolean isWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }
    }
    private class TrieNode {
        boolean isWord;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}