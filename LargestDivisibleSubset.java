/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
*/

public class Solution {
    // Time O(n^2))
    // Space O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
        
        List<Integer> result = new ArrayList<Integer>();
        
        int maxSize = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    List<Integer> temp = new ArrayList<Integer>(cache.get(j));
                    temp.add(nums[i]);
                    if (temp.size() > max) {
                        max = temp.size();
                        cache.put(i, temp);
                        if (max > maxSize) {
                            result = temp;
                            maxSize = temp.size();
                            break;
                        }
                    }
                }
            }
            if (cache.get(i) == null) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                cache.put(i, temp);
                if (temp.size() > maxSize) {
                    result = temp;
                    maxSize = temp.size();
                }
            }
        }
        return result;
    }
}