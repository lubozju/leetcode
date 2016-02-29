/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int newTarget = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (newTarget < nums[left] + nums[right]) {
                        right--;
                    } else if (newTarget > nums[left] + nums[right]) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (nums[left] == nums[left - 1] && left < right) {
                            left++;
                        }
                        while (nums[right] == nums[right + 1] && left < right) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}