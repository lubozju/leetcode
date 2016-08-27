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

public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
            i++;
        }
        
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[index] = 0;
            }
            index++;
        }
    }
}


public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 0) {
            i++;
        }
        
        int index = i;
        while (i < nums.length) {
            if (nums[i] != 0) {
                swap(nums, i, index);
                index++;
            }
            i++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}