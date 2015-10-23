/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        dfs(n, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void dfs(int n, List<String> path, List<List<String>> result) {
        if (path.size() == n) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            char[] cArray = new char[n];
            Arrays.fill(cArray, '.');
            if (check(i, path)) {
                cArray[i] = 'Q';
                path.add(new String(cArray));
                dfs(n, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean check(int i, List<String> path) {
        for (int j = 0; j < path.size(); j++) {
            String pos = path.get(j);
            if (pos.charAt(i) == 'Q') {
                return false;
            }
            int k = path.size() - j + i;
            if (k >= 0 && k < pos.length() && pos.charAt(k) == 'Q') {
                return false;
            }
            
            k = j - path.size() + i;
            if (k >= 0 && k < pos.length() && pos.charAt(k) == 'Q') {
                return false;
            }
        }
        return true;
    }
}