/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    // Initialize your data structure here.
    String value;
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        value = "";
        isWord = false;
        children = new TrieNode[26];
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
    public boolean isWord() {
        return isWord;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
                String value = temp.value + c;
                temp.children[c - 'a'].setValue(value);
            }
            temp = temp.children[c - 'a'];
        }
        temp.setIsWord(true);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return temp.isWord();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");