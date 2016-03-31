/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[candidates.length];
        dfs(target, candidates, 0, new ArrayList<Integer>(), result, visited);
        
        return result;
    }
    
    private void dfs(int target, int[] candidates, int index, List<Integer> path, List<List<Integer>> result, boolean[] visited) {
        if (target == 0 && path.size() > 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(candidates[i]);
            dfs(target - candidates[i], candidates, i + 1, path, result, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}