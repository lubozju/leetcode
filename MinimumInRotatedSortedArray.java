/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                if (nums[mid] > nums[left]) {
                    return nums[left];
                }
                // mid could be the minimum number since nums[mid] < nums[left] && nums[mid] < nums[right]
                right = mid;
            }
        }
        
        return nums[left];
    }
}