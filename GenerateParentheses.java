/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<String>();
        
        dfs(n, 0, 0, new String(), result);
        
        return result;
    }
    
    private void dfs(int n, int countL, int countR, String path, List<String> result) {
        if (path.length() == n * 2) {
            if (countL == countR) {
                result.add(path);
            }
            return;
        }
        if (countL < n) {
            dfs(n, countL + 1, countR, path + "(", result);
        }
        if (countL > countR) {
            dfs(n, countL, countR + 1, path + ")", result);
        }
    }
}