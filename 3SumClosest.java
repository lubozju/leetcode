/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int newTarget = target - nums[i];
            int temp = twoSumCloset(nums, j, k, newTarget);
            if (Math.abs(target - (nums[i] + temp)) < min) {
                min = Math.abs(target - (nums[i] + temp));
                result = nums[i] + temp;
            }
        }
        return result;
    }
    
    private int twoSumCloset(int[] nums, int j, int k, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        while (j < k) {
            int sum = nums[j] + nums[k];
            if (sum == target) {
                return sum;
            }
            if (Math.abs(target - sum) < min) {
                min = Math.abs(target - sum);
                result = sum;
            }
            if (sum < target) {
                j++;
            } else {
                k--;
            }
        }
        return result;
    }
}