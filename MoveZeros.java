/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums != null) {
            int i = 0;
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            
            int firstZero = i;
            for (int k = i; k < nums.length; k++) {
                if (nums[k] != 0) {
                    nums[firstZero] = nums[k];
                    firstZero++;
                }
            }
            
            Arrays.fill(nums, firstZero, nums.length, 0);
        }
    }
}