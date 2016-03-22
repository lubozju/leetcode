/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        dfs(nums, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> result) {
        int size = path.size();
        if (size == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.length - size; i++) {
            path.add(nums[i]);
            swap(nums, i, nums.length - 1 - size);
            dfs(nums, path, result);
            swap(nums, i, nums.length - 1 - size);
            path.remove(path.size() - 1);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}