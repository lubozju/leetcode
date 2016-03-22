/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, visited, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        int size = path.size();
        
        if (nums.length == size) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, path, result);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}