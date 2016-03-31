/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        dfs(k, n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int k, int n, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = path.size() == 0 ? 1 : path.get(path.size() - 1) + 1; i <= n; i++) {
            path.add(i);
            dfs(k, n, path, result);
            path.remove(path.size() - 1);
        }
    }
}