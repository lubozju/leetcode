/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left, index);
                left++;
            } else if (nums[index] == 2) {
                swap(nums, right, index);
                right--;
                if (nums[index] == 0) {
                    swap(nums, left, index);
                    left++;
                }
            }
            if (nums[index] != 2) {
                index++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            while (nums[i] == 2 && i < two) {
                swap(nums, i, two);
                two--;
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero);
                zero++;
            }
            i++;
        }
    } 
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}