/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue;
            }
            dfs(nums, j, path, result);
        }
        
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int jIndex = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                jIndex = size;
            }
            size = result.size();
            for (int j = jIndex; j < size; j++) {
                List<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}