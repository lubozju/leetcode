/*
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }
        
        Trie trieR = new Trie();
        for (int i = 0; i < words.length; i++) {
            trieR.addWord(new StringBuilder(words[i]).reverse().toString(), i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String wordR = new StringBuilder(words[i]).reverse().toString();
            List<Integer> indexes = trie.isPrefix(wordR);
            for (Integer index : indexes) {
                if (index == i) {
                    continue;
                }
                if (isPalin(words[index] + words[i])) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(index);
                    temp.add(i);
                    result.add(temp);
                }
            }
            
            indexes = trieR.isPrefix(words[i]);
            for (Integer index : indexes) {
                if (index == i) {
                    continue;
                }
                if (isPalin(words[i] + words[index])) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(index);
                    result.add(temp);
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
        
    }
    
    private boolean isPalin(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void addWord(String word, int index) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.index = index;
        }
        
        List<Integer> isPrefix(String prefix) {
            List<Integer> result = new ArrayList<Integer>();
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (node == null) {
                    return result;
                }
                char c = prefix.charAt(i);
                if (node.children[c- 'a'] == null) {
                    return result;
                }
                node = node.children[c- 'a'];
            }
            dfs(node, result);
            return result;
        }
        
        void dfs(TrieNode node, List<Integer> indexes) {
            if (node.index != -1) {
                indexes.add(node.index);
            }
            for (TrieNode child : node.children) {
                if (child != null) {
                    dfs(child, indexes);
                }
            }
        }
    }
    private class TrieNode {
        int index;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
            index = -1;
        }
    }
}