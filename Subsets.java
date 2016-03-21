/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(nums, -1, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {
        if (i >= 0) {
            path.add(nums[i]);
        }
        result.add(new ArrayList<Integer>(path));
        for (int j = i + 1; j < nums.length; j++) {
            dfs(nums, j, path, result);
        }
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }
    }
}