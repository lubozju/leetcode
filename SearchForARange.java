/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int leftIndex = findLeft(nums, target);
        if (leftIndex == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        int rightIndex = findRight(nums, target);
        result[0] = leftIndex;
        result[1] = rightIndex;
        
        return result;
    }
    
    private int findLeft(int[] nums, int target) {
        int left = -1;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
    
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}