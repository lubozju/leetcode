/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

click to show hint.

You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/

public class WordDictionary {

    private TrieNode root = new TrieNode('a');
    
    private class TrieNode {
        char letter;
        boolean isWord; // mark the node to the last letter of a word
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        
        private TrieNode(char c) {
            letter = c;
        }
        
        Map<Character, TrieNode> getChildren() {
            return children;
        }
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Map<Character, TrieNode> children = cur.getChildren();
            TrieNode node = children.get(c);
            if (node == null) {
                node = new TrieNode(c);
                children.put(c, node);
            }
            cur = node;
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(root, 0, word);
    }
    
    private boolean dfs(TrieNode node, int cur, String word) {
        if (cur == word.length()) {
            if (node.isWord == true) {
                return true;
            }
            return false;
        }
        
        char c = word.charAt(cur);
        if (c == '.') {
            for (TrieNode child : node.getChildren().values()) {
                if (dfs(child, cur + 1, word) == true) {
                    return true;
                }
            }
        } else {
            TrieNode child = node.getChildren().get(c);
            if (child == null) {
                return false;
            }
            if (dfs(child, cur + 1, word) == true) {
                return true;
            }
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");