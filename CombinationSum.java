/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        dfs(target, candidates, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int target, int[] candidates, int index, List<Integer> path, List<List<Integer>> result) {
        if (target == 0 && path.size() > 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(target - candidates[i], candidates, i, path, result);
                path.remove(path.size() - 1);
            } else {
                break;
            } 
        }
    }
}