/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        // int[] result = new int[nums.length];
        
        // for (int i = 0; i < nums.length; i++) {
        //     result[(i + k) % nums.length] = nums[i];
        // }
        
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = result[i];
        // }
        
        int len = nums.length;
        reverse(nums, 0, (len - k % len) - 1);
        reverse(nums, (len - k % len), nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}