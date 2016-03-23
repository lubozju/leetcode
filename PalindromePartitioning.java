/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(s, 0, new ArrayList<String>(), result);
        return result;
    }
    
    private void dfs(String s, int index, List<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (isPalin(word)) {
                path.add(word);
                dfs(s, i, path, result);
                path.remove(path.size() - 1);
            }
        }
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
}